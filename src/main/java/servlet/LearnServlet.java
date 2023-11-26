package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.ThesaurusDaoImpl;
import jdbc.dao.NewWordDaoImpl;
import jdbc.entity.Thesaurus;
import jdbc.entity.NewWord;

@WebServlet("/LearnServlet")
public class LearnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String wList;
	private static int uId;
	private static List<NewWord> newWordList;
	private static int previous;
	private static int current;

    public LearnServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String wordList = (String) session.getAttribute("userWordList");
		int uesrId= (int) session.getAttribute("uid");
		
		NewWordDaoImpl newWordDao =new NewWordDaoImpl();	
		NewWord newWord =new NewWord();
		if(wordList.equals(wList)&&uesrId==uId) {
			getNewWordId(request, response);
			System.out.println("ʹ���Ѵ������ʱ�");
		}else {
			// ��ȡѡ��Ĵʿ⣬Ȼ���ȡ�ʿⵥ��id�б�Ȼ������������ݿ⣬
			// ����������򴴽����ʣ��������ж������ȣ�������С��30�ı���������������id�б�
			newWordList = new ArrayList<>();
			previous = 0;
			current = 0;
			ThesaurusDaoImpl thesaurusDao = new ThesaurusDaoImpl();
			List<Thesaurus> thesaurusList = thesaurusDao.listThesaurusByName(wordList);
			
			for (Thesaurus thesaurus : thesaurusList) {
				int wordId = thesaurus.getThesaurus_wid();
				newWord = newWordDao.findNewWordByWidAndUid(wordId, uesrId);
				
				if(newWord.getNewword_proficiency()==null) {
					newWord.setNewword_wid(wordId);
					newWord.setNewword_uid(uesrId);
					newWord.setNewword_reviewtimes(1);
					newWord.setNewword_forgettimes(0);
					newWord.setNewword_proficiency(0);
					newWordDao.addNewWord(newWord);
					newWord = newWordDao.findNewWordByWidAndUid(wordId, uesrId);
					newWordList.add(newWord);
				}else if(newWord.getNewword_proficiency()<30){
					newWordList.add(newWord);
				}else {
					continue;
				}
			}
			System.out.println("�½����ʱ�");
			wList = wordList;
			uId = uesrId;
			getNewWordId(request, response);
		}
		// �ض���ҳ��
		response.sendRedirect("/words/learn.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void getNewWordId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��������id��jsp,�ض���
		// ��ȡjsp ��ťֵ����ʶ��+5��ģ����-5������-10����СΪ0
		// �������������ȣ�ȡ����һ������id����jsp���ض���
		// �����б��꣬���ݽ�����־��jsp,�ض���
		String buttonReturn = request.getParameter("wordProficiency");
		int length = newWordList.size();
		System.out.println("���ʱ�length" + length);
		HttpSession session = request.getSession();
		int tmp = 1;
		session.setAttribute("NewWordId",tmp);
		NewWordDaoImpl newWordDao =new NewWordDaoImpl();
		int previousNewWordId = newWordList.get(previous).getNewword_id();
		int currentNewWordId = newWordList.get(current).getNewword_id();
		NewWord newWord =new NewWord();
		newWord = newWordDao.findNewWordById(previousNewWordId);
		
		int proficiency = newWord.getNewword_proficiency();
		int reviewtimes = newWord.getNewword_reviewtimes();
		int forgettimes = newWord.getNewword_forgettimes();
		if("clear".equals(buttonReturn)) {
			proficiency += 5;
			newWord.setNewword_proficiency(proficiency);
			reviewtimes += 1;
			newWord.setNewword_reviewtimes(reviewtimes);
			newWordDao.updateNewWord(newWord);
		}else if("blur".equals(buttonReturn)) {
			proficiency -= 5;
			if(proficiency < 0) {
				proficiency = 0;
			}
			newWord.setNewword_proficiency(proficiency);
			reviewtimes += 1;
			newWord.setNewword_reviewtimes(reviewtimes);
			newWordDao.updateNewWord(newWord);
		}else if("forget".equals(buttonReturn)) {
			proficiency -= 10;
			if(proficiency < 0) {
				proficiency = 0;
			}
			newWord.setNewword_proficiency(proficiency);
			reviewtimes += 1;
			forgettimes += 1;
			newWord.setNewword_reviewtimes(reviewtimes);
			newWord.setNewword_forgettimes(forgettimes);
			newWordDao.updateNewWord(newWord);
		}
		previous = current;
		if(current<length) {
			session.setAttribute("NewWordId", currentNewWordId);
			session.setAttribute("NewWordListFlag", "listNotEnd");
			current = current+1;
		}else {
			session.setAttribute("NewWordListFlag", "listEnd!"); 
			
			current = 0;
		}
		
	}

}

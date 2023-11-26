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
			System.out.println("使用已存在生词表");
		}else {
			// 获取选择的词库，然后获取词库单词id列表，然后遍历生词数据库，
			// 如果不存在则创建生词，存在则判断熟练度，熟练度小于30的保留，生成新生词id列表
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
			System.out.println("新建生词表");
			wList = wordList;
			uId = uesrId;
			getNewWordId(request, response);
		}
		// 重定向页面
		response.sendRedirect("/words/learn.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void getNewWordId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 传递生词id给jsp,重定向
		// 获取jsp 按钮值，认识则+5，模糊则-5，忘记-10，最小为0
		// 设置生词熟练度，取出下一个生词id传给jsp，重定向
		// 生词列表完，传递结束标志给jsp,重定向
		String buttonReturn = request.getParameter("wordProficiency");
		int length = newWordList.size();
		System.out.println("生词表length" + length);
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

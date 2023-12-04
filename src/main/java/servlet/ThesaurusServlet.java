package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.ThesaurusDaoImpl;
import jdbc.dao.NewWordDaoImpl;
import jdbc.entity.Thesaurus;
import jdbc.entity.NewWord;


@WebServlet("/ThesaurusServlet")
public class ThesaurusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ThesaurusServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int Uid;
		if(session.getAttribute("uid")!=null) {
			Uid = (int) session.getAttribute("uid");
		}else {
			Uid = (int) request.getAttribute("uid");
		}
		int thesaurusCount = 0;
		int Count = 0;
		int CET4luan_1 = 0;
		int CET6luan_1 = 0;
		int KaoYanluan_1 = 0;
		ThesaurusDaoImpl thesaurusDao = new ThesaurusDaoImpl();
		NewWordDaoImpl newWordDao =new NewWordDaoImpl();	
		NewWord newWord =new NewWord();
		
		List<Thesaurus> thesaurusList = thesaurusDao.listThesaurusByName("CET4luan_1");
		thesaurusCount = thesaurusDao.countThesaurus("CET4luan_1");
		List<NewWord> newWordList = newWordDao.NewwordAndThesaurus(Uid, "CET4luan_1");
		for (NewWord n : newWordList) {
			
			if(n.getNewword_proficiency()!=null&&n.getNewword_proficiency()>=20) {
				Count++;
			}
		}
		if(Count!=0) {
			CET4luan_1 = (Count*100)/thesaurusCount;
			System.out.println(CET4luan_1);
			session.setAttribute("Count_CET4luan_1", CET4luan_1);
		}else {
			session.setAttribute("Count_CET4luan_1", CET4luan_1);
		}

		thesaurusCount = 0;
		Count = 0;
		thesaurusList = thesaurusDao.listThesaurusByName("CET6luan_1");
		thesaurusCount = thesaurusDao.countThesaurus("CET6luan_1");
		for (Thesaurus thesaurus : thesaurusList) {
			newWord = newWordDao.findNewWordByWidAndUid(thesaurus.getThesaurus_wid(), Uid);
			if(newWord.getNewword_proficiency()!=null&&newWord.getNewword_proficiency()>=20) {
				Count++;
			}
		}
		if(Count!=0) {
			CET6luan_1 = (Count*100)/thesaurusCount;
			System.out.println(CET6luan_1);
			session.setAttribute("Count_CET6luan_1", CET6luan_1);
		}else {
			session.setAttribute("Count_CET6luan_1", CET6luan_1);
		}

		thesaurusCount = 0;
		Count = 0;
		thesaurusList = thesaurusDao.listThesaurusByName("KaoYanluan_1");
		thesaurusCount = thesaurusDao.countThesaurus("KaoYanluan_1");
		for (Thesaurus thesaurus : thesaurusList) {
			newWord = newWordDao.findNewWordByWidAndUid(thesaurus.getThesaurus_wid(), Uid);
			if(newWord.getNewword_proficiency()!=null&&newWord.getNewword_proficiency()>=20) {
				Count++;
			}
		}
		if(Count!=0) {
			KaoYanluan_1 = (Count*100)/thesaurusCount;
			session.setAttribute("Count_KaoYanluan_1", KaoYanluan_1);
		}else {
			session.setAttribute("Count_KaoYanluan_1", KaoYanluan_1);
		}
		
		//重定向页面
		response.sendRedirect("/words/index.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

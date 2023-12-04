package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.ThesaurusDaoImpl;
import jdbc.dao.WordDao;
import jdbc.dao.WordDaoImpl;
import jdbc.entity.Thesaurus;
import jdbc.entity.Word;

@WebServlet("/PageToWordList")
public class PageToWordList extends HttpServlet { 	
	private static final long serialVersionUID = 1L;


	public PageToWordList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String thesaurusName = "CET4luan_1";
		if(session.getAttribute("wordlistname")!=null){
			thesaurusName = (String) session.getAttribute("wordlistname");
		}
		
		WordDaoImpl wordDao = new WordDaoImpl();
		List<Word> wordList = wordDao.WordAndThesaurus(thesaurusName);
		session.setAttribute("wordList", wordList);	
		//重定向页面
		response.sendRedirect("/words/word-list-detail.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}

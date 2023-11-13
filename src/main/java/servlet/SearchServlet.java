package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.WordDaoImpl;
import jdbc.entity.Word;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String searchword = request.getParameter("searchword");
			WordDaoImpl wordDao = new WordDaoImpl();
			List<Word> results = wordDao.findWordByEnFuzzy(searchword);
			
			HttpSession session = request.getSession();
			session.setAttribute("results", results);
			//重定向页面
			response.sendRedirect("/words/search.jsp");
	}

}

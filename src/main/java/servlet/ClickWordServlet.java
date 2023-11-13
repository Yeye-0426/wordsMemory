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

import jdbc.dao.WordDaoImpl;
import jdbc.entity.Word;


@WebServlet("/ClickWordServlet")
public class ClickWordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClickWordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String clickedword = request.getParameter("clickedword");
			WordDaoImpl wordDao = new WordDaoImpl();
			Word clickword = wordDao.findWordByEn(clickedword);
			
			HttpSession session = request.getSession();
			session.setAttribute("clickword", clickword);
			//重定向页面
			response.sendRedirect("/words/word-detail.jsp");
	}

}

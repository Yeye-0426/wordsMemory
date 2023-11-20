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
import jdbc.entity.Thesaurus;


@WebServlet("/ClickWordListServlet")
public class ClickWordListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClickWordListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String wordlistname = request.getParameter("clickedwordlist");
		
		HttpSession session = request.getSession();
		session.setAttribute("wordlistname", wordlistname);
		
		//重定向页面
		response.sendRedirect("/words/word-list-detail.jsp");
	}

}

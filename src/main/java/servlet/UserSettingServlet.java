package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.UserDaoImpl;
import jdbc.entity.User;

@WebServlet("/UserSettingServlet")
public class UserSettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserSettingServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("user_id");
		String uemail = request.getParameter("user_email");
		String upwd = request.getParameter("user_pass");
		String wordList = request.getParameter("word_list");
		
		HttpSession session = request.getSession();
		int userId =  (int) session.getAttribute("uid");
		UserDaoImpl UserDao = new UserDaoImpl();
		User user = new User();
		
		String userWordList = wordList;
		
		user.setUser_id(userId);
		user.setUser_name(uname); 
		user.setUser_email(uemail); 
		user.setUser_password(upwd); 
		user.setUser_pepdom("1");
		UserDao.updateuser(user);
		
		session.setAttribute("uname", user.getUser_name());
		session.setAttribute("uemail",uemail);
		session.setAttribute("upwd",upwd);
		session.setAttribute("userWordList", userWordList);
		response.sendRedirect("/words/user-setting.jsp");
	}
}

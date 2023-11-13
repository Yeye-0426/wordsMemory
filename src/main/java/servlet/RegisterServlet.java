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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/// 通知浏览器以UTF-8编码显示，说明服务器端字符编码为UTF-8
		response.setContentType("text/html;charset=utf-8");
		String url = "/register.jsp";
		url = register(request, response);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String url = "/register.jsp";
		url = register(request, response);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	private String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/register.jsp";
		
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String upwd = request.getParameter("upwd");
		String repwd = request.getParameter("repwd");
		
		HttpSession session = request.getSession();
		User user = new User();
		user.setUser_name(uname); 
		user.setUser_email(uemail); 
		user.setUser_password(upwd); 
		user.setUser_pepdom("1");  

		// 判断两次密码是否一致
		if(upwd.equals(repwd)) {
			UserDaoImpl UserDao = new UserDaoImpl();
			UserDao.adduser(user);
			url = "/login.jsp";
			return url;
		}else {
			return url;
		}
	}
}

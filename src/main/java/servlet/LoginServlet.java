package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.UserDaoImpl;
import jdbc.entity.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	// servlet中默认使用get，因此在doGet函数中实现自动免登陆
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String uemail = null;
		String upwd = null;
		// 判断是否获取到Cookie
		if (cookies != null) {
			// 遍历Cookie找到需要的用户名值和密码值
			for (Cookie cookie : cookies) {
				if (cookie.getName().compareTo("uemail") == 0) {
					uemail = cookie.getValue();
				} else if (cookie.getName().compareTo("upwd") == 0) {
					upwd = cookie.getValue();
				}

			}
		}
		// 判断用户名密码是否正确
		UserDaoImpl userDao = new UserDaoImpl();
		if (userDao.login(uemail, upwd)) {
			User user = userDao.finduserByEmail(uemail);
			// 获取session对象
			HttpSession session = request.getSession();
			// 将用户id和用户名追加到session中
			int userId = user.getUser_id();
			session.setAttribute("uname", user.getUser_name());
			session.setAttribute("uid",userId);
			session.setAttribute("uemail",uemail);
			session.setAttribute("upwd",upwd);
			// 跳转到词库统计 
			request.setAttribute("uid",userId);
			request.getRequestDispatcher("/ThesaurusServlet").forward(request, response);
		} else {
			response.sendRedirect("/words/login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 通知浏览器以UTF-8编码显示，说明服务器端字符编码为UTF-8
		response.setContentType("text/html;charset=utf-8");
		String uemail = request.getParameter("uemail");
		String upwd = request.getParameter("upwd");
		String remeber = request.getParameter("remeber");

		// 判断用户名密码是否正确
		UserDaoImpl userDao = new UserDaoImpl();
		if (userDao.login(uemail, upwd)) {
			System.out.print("登录成功");
			// 判断是否开启免登陆
			if ("on".equals(remeber)) {
				// 创建Cookie
				Cookie email = new Cookie("uemail", uemail);
				Cookie pwd = new Cookie("upwd", upwd);
				// 设置Cookie的生存时间
				email.setMaxAge(60 * 60 * 24 * 3);
				pwd.setMaxAge(60 * 60 * 24 * 3);
				// 向客户端发送cookie
				response.addCookie(email);
				response.addCookie(pwd);
			} else {
				// 没有选择免登陆时，将Cookie生存时间设置为零
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().compareTo("uemail") == 0) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						} else if (cookie.getName().compareTo("upwd") == 0) {
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
			}
			User user = userDao.finduserByEmail(uemail);
			// 获取session对象
			HttpSession session = request.getSession();
			// 将用户id和用户名追加到session中
			int userId = user.getUser_id();
			session.setAttribute("uname", user.getUser_name());
			session.setAttribute("uid",userId);
			session.setAttribute("uemail",uemail);
			session.setAttribute("upwd",upwd);
			// 跳转到词库统计 
			request.setAttribute("uid",userId);
			request.getRequestDispatcher("/ThesaurusServlet").forward(request, response);
		} else {
			System.out.print("登录失败");
			// 重定向到登陆页面
			response.sendRedirect("/words/login.jsp");
		}

	}
}

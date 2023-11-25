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

	// servlet��Ĭ��ʹ��get�������doGet������ʵ���Զ����½
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String uemail = null;
		String upwd = null;
		// �ж��Ƿ��ȡ��Cookie
		if (cookies != null) {
			// ����Cookie�ҵ���Ҫ���û���ֵ������ֵ
			for (Cookie cookie : cookies) {
				if (cookie.getName().compareTo("uemail") == 0) {
					uemail = cookie.getValue();
				} else if (cookie.getName().compareTo("upwd") == 0) {
					upwd = cookie.getValue();
				}

			}
		}
		// �ж��û��������Ƿ���ȷ
		UserDaoImpl userDao = new UserDaoImpl();
		if (userDao.login(uemail, upwd)) {
			User user = userDao.finduserByEmail(uemail);
			// ��ȡsession����
			HttpSession session = request.getSession();
			// ���û�id���û���׷�ӵ�session��
			int userId = user.getUser_id();
			session.setAttribute("uname", user.getUser_name());
			session.setAttribute("uid",userId);
			session.setAttribute("uemail",uemail);
			session.setAttribute("upwd",upwd);
			// ��ת���ʿ�ͳ�� 
			request.setAttribute("uid",userId);
			request.getRequestDispatcher("/ThesaurusServlet").forward(request, response);
		} else {
			response.sendRedirect("/words/login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ֪ͨ�������UTF-8������ʾ��˵�����������ַ�����ΪUTF-8
		response.setContentType("text/html;charset=utf-8");
		String uemail = request.getParameter("uemail");
		String upwd = request.getParameter("upwd");
		String remeber = request.getParameter("remeber");

		// �ж��û��������Ƿ���ȷ
		UserDaoImpl userDao = new UserDaoImpl();
		if (userDao.login(uemail, upwd)) {
			System.out.print("��¼�ɹ�");
			// �ж��Ƿ������½
			if ("on".equals(remeber)) {
				// ����Cookie
				Cookie email = new Cookie("uemail", uemail);
				Cookie pwd = new Cookie("upwd", upwd);
				// ����Cookie������ʱ��
				email.setMaxAge(60 * 60 * 24 * 3);
				pwd.setMaxAge(60 * 60 * 24 * 3);
				// ��ͻ��˷���cookie
				response.addCookie(email);
				response.addCookie(pwd);
			} else {
				// û��ѡ�����½ʱ����Cookie����ʱ������Ϊ��
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
			// ��ȡsession����
			HttpSession session = request.getSession();
			// ���û�id���û���׷�ӵ�session��
			int userId = user.getUser_id();
			session.setAttribute("uname", user.getUser_name());
			session.setAttribute("uid",userId);
			session.setAttribute("uemail",uemail);
			session.setAttribute("upwd",upwd);
			// ��ת���ʿ�ͳ�� 
			request.setAttribute("uid",userId);
			request.getRequestDispatcher("/ThesaurusServlet").forward(request, response);
		} else {
			System.out.print("��¼ʧ��");
			// �ض��򵽵�½ҳ��
			response.sendRedirect("/words/login.jsp");
		}

	}
}

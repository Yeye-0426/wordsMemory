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

import jdbc.dao.ExamDaoImpl;
import jdbc.entity.Exam;

@WebServlet("/ExamServlet")
public class ExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static List<Exam> examList;
	private static int previous;
	private static int current;
	private static int next;

    public ExamServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/words/test.jsp";
		HttpSession session = request.getSession();
		String thesaurusName = (String) session.getAttribute("userWordList");
		int examType = 1;
		if("CET4luan_1".equals(thesaurusName)) {
			examType = 1;
		}else if("CET6luan_1".equals(thesaurusName)) {
			examType = 1;
		}

		if(examList != null) {
			getExamId(request, response);
			System.out.println("ʹ���Ѵ��ڲ��Ա�");
		}else {
			// ��ȡ�ʿ�Ĳ����б�
			ExamDaoImpl examDao = new ExamDaoImpl();
			examList = examDao.findByType(examType);	
			previous = 0;
			current = 0;
			next = 0;
			System.out.println("�½����Ա�");
			getExamId(request, response);
		}
		// �ض���ҳ��
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected String getExamId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/words/test.jsp";
		// ���ݲ���id��jsp,�ض���
		// ��ȡjsp��ťֵ��previous��next�����ò���id����jsp���ض���
		// �����б��꣬���ݽ�����־��jsp,�ض���
		String order = request.getParameter("btn");
		int length = examList.size();
		System.out.println("���Ա�length" + length);
		HttpSession session = request.getSession();
		int tmp = 1;
		session.setAttribute("ExamId",tmp);
		int examId = examList.get(current).getExam_id();
		if(request.getParameter("btn")!=null) {
			if(current<0) {
				session.setAttribute("TestListFlag", "listFirst!");
				current = 0;
			}else if(current<length){
				if("previous".equals(order)) {
					current = previous;
				}else if("next".equals(order)) {
					current = next;
				}
				if(current<0) {current = 0;}
				session.setAttribute("TestListFlag", "listNotEnd");
				
			}else {
				session.setAttribute("TestListFlag", "listEnd!");
				current = 0;
			}
			examId = examList.get(current).getExam_id();
			session.setAttribute("ExamId", examId);
			previous = current - 1;
			next = current + 1;
			session.removeAttribute("TestRightFlag");
		}else {
			url = "/words/login.jsp";
			return url;
		}
		return url;
	}

}

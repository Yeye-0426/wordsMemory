package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.entity.Exam;
import jdbc.entity.Word;
import jdbc.utils.DBUtils;

public class ExamDaoImpl implements ExamDao {

	@Override
	public int add(Exam exam) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="INSERT INTO exam(exam_type, exam_wid, "
					+ "question, choice_1, choice_2, choice_3, choice_4, "
					+ "exam_explain, rightindex)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, exam.getExam_type());
			pstmt.setInt(2, exam.getExam_wid());
			pstmt.setString(3, exam.getQuestion());
			pstmt.setString(4, exam.getChoice1());
			pstmt.setString(5, exam.getChoice2());
			pstmt.setString(6, exam.getChoice3());
			pstmt.setString(7, exam.getChoice4());
			pstmt.setString(8, exam.getExam_explain());
			pstmt.setInt(9, exam.getRightindex());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows;
	}

	@Override
	public int update(Exam exam) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Exam findById(int exam_id) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    Exam exam = new Exam();
	    try {
	        conn = DBUtils.getConnection();
	        String sql = "SELECT exam_id, exam_type, exam_wid, question, choice_1, "
	        		+ "choice_2, choice_3, choice_4, exam_explain, rightindex, "
	        		+ "exam_modificationtime FROM exam WHERE exam_id = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, exam_id);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	        	exam.setExam_id(rs.getInt("exam_id"));
	        	exam.setExam_type(rs.getInt("exam_type"));
	        	exam.setExam_wid(rs.getInt("exam_wid"));
	        	exam.setQuestion(rs.getString("question"));
	        	exam.setChoice1(rs.getString("choice_1"));
	        	exam.setChoice2(rs.getString("choice_2"));
	        	exam.setChoice3(rs.getString("choice_3"));
	        	exam.setChoice4(rs.getString("choice_4"));
	        	exam.setExam_explain(rs.getString("exam_explain"));
	        	exam.setRightindex(rs.getInt("rightindex"));
	        	exam.setExamModificationtime(rs.getString("exam_modificationtime"));
	        	}
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	        DBUtils.destroy(conn, pstmt, rs);
	    }
	    return exam;
	}
	
	@Override
	public List<Exam> findByType(int exam_type) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    List<Exam> examlist = new ArrayList<Exam>();
	    try {
	        conn = DBUtils.getConnection();
	        String sql = "SELECT exam_id, exam_type, exam_wid, question, choice_1, "
	        		+ "choice_2, choice_3, choice_4, exam_explain, rightindex, "
	        		+ "exam_modificationtime FROM exam WHERE exam_type = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, exam_type);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	Exam exam = new Exam();
	        	exam.setExam_id(rs.getInt("exam_id"));
	        	exam.setExam_type(rs.getInt("exam_type"));
	        	exam.setExam_wid(rs.getInt("exam_wid"));
	        	exam.setQuestion(rs.getString("question"));
	        	exam.setChoice1(rs.getString("choice_1"));
	        	exam.setChoice2(rs.getString("choice_2"));
	        	exam.setChoice3(rs.getString("choice_3"));
	        	exam.setChoice4(rs.getString("choice_4"));
	        	exam.setExam_explain(rs.getString("exam_explain"));
	        	exam.setRightindex(rs.getInt("rightindex"));
	        	exam.setExamModificationtime(rs.getString("exam_modificationtime"));
	        	examlist.add(exam);
	        	}
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	        DBUtils.destroy(conn, pstmt, rs);
	    }
	    return examlist;
	}

}


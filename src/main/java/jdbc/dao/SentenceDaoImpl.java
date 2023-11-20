package jdbc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.entity.Sentence;
import jdbc.utils.DBUtils;

public class SentenceDaoImpl implements SentenceDao{

	@Override
	public List<Sentence> listAll() {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<Sentence> sentencelist = new ArrayList<Sentence>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT sentence_id, sentence_wid, sentence_wen, sentence_en, sentence_cn, sentence_modificationtime"
					+ " FROM sentences";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sentence sentence = new Sentence();
				sentence.setSentence_id(rs.getInt("sentence_id"));
				sentence.setSentence_wid(rs.getInt("sentence_wid"));
				sentence.setSentence_wen(rs.getString("sentence_wen"));
				sentence.setSentence_en(rs.getString("sentence_en"));
				sentence.setSentence_cn(rs.getString("sentence_cn"));
				sentence.setSentence_modificationtime(rs.getString("sentence_modificationtime"));
				sentencelist.add(sentence); 
				}

		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return sentencelist; 
	}

	@Override
	public boolean addSentence(Sentence sentence) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="INSERT INTO sentence(sentence_wid, sentence_wen, sentence_en, sentence_cn, sentence_modificationtime) "
					+ " values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sentence.getSentence_wid());
			pstmt.setString(2, sentence.getSentence_wen());
			pstmt.setString(3, sentence.getSentence_en());
			pstmt.setString(4, sentence.getSentence_cn());
			pstmt.setString(5, sentence.getSentence_modificationtime());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean deleteSentence(Integer sentence_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="DELETE FROM sentences WHERE sentence_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sentence_id); 
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean updateSentence(Sentence sentence) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql = "UPDATE sentence SET " +
					"sentence_wid = ?," +
					"sentence_wen = ?, " +
					"sentence_en = ?, " +
                    "sentence_cn = ?, " +
                    "sentence_modificationtime = ?, " +
                    "WHERE sentence_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sentence.getSentence_wid());
			pstmt.setString(2, sentence.getSentence_wen());
			pstmt.setString(3, sentence.getSentence_en());
			pstmt.setString(4, sentence.getSentence_cn());
			pstmt.setString(5, sentence.getSentence_modificationtime());
			pstmt.setInt(6, sentence.getSentence_id());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public Sentence findSentenceById(Integer sentence_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		Sentence sentence = new Sentence();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT sentence_id, sentence_wid, sentence_wen, sentence_en, sentence_cn, sentence_modificationtime "
					+ " FROM sentences WHERE sentence_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sentence_id); 
			rs = pstmt.executeQuery();
	        if (rs.next()) {
				sentence.setSentence_id(rs.getInt("sentence_id"));
				sentence.setSentence_wid(rs.getInt("sentence_wid"));
				sentence.setSentence_wen(rs.getString("sentence_wen"));
				sentence.setSentence_en(rs.getString("sentence_en"));
				sentence.setSentence_cn(rs.getString("sentence_cn"));
				sentence.setSentence_modificationtime(rs.getString("sentence_modificationtime"));
	        }
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return sentence;
	}

	@Override
	public List<Sentence> listSentenceByWid(Integer sentence_wid) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<Sentence> sentencelist = new ArrayList<Sentence>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT sentence_id, sentence_wid, sentence_wen, sentence_en, sentence_cn, sentence_modificationtime "
					+ " FROM sentences WHERE sentence_wid = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sentence_wid); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sentence sentence = new Sentence();
				sentence.setSentence_id(rs.getInt("sentence_id"));
				sentence.setSentence_wid(rs.getInt("sentence_wid"));
				sentence.setSentence_wen(rs.getString("sentence_wen"));
				sentence.setSentence_en(rs.getString("sentence_en"));
				sentence.setSentence_cn(rs.getString("sentence_cn"));
				sentence.setSentence_modificationtime(rs.getString("sentence_modificationtime"));
				sentencelist.add(sentence); 
				}

		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return sentencelist; 
	}
	
	@Override
	public List<Sentence> listSentenceByWen(String sentence_wen) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<Sentence> sentencelist = new ArrayList<Sentence>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT sentence_id, sentence_wid, sentence_wen, sentence_en, sentence_cn, sentence_modificationtime "
					+ " FROM sentences WHERE sentence_wen = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sentence_wen); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sentence sentence = new Sentence();
				sentence.setSentence_id(rs.getInt("sentence_id"));
				sentence.setSentence_wid(rs.getInt("sentence_wid"));
				sentence.setSentence_wen(rs.getString("sentence_wen"));
				sentence.setSentence_en(rs.getString("sentence_en"));
				sentence.setSentence_cn(rs.getString("sentence_cn"));
				sentence.setSentence_modificationtime(rs.getString("sentence_modificationtime"));
				sentencelist.add(sentence); 
				}

		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return sentencelist; 
	}
	
}

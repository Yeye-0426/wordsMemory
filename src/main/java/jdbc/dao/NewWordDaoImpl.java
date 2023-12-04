package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.entity.NewWord;
import jdbc.entity.Word;
import jdbc.utils.DBUtils;

public class NewWordDaoImpl implements NewWordDao {

	@Override
	public List<NewWord> listAll() {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<NewWord> newwordlist = new ArrayList<NewWord>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT newword_id, newword_wid, newword_uid, newword_reviewtimes, newword_forgettimes, "
					+ "newword_proficiency, newword_modificationtime FROM newword";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NewWord newword = new NewWord();
				newword.setNewword_id(rs.getInt("newword_id"));
				newword.setNewword_wid(rs.getInt("newword_wid"));
				newword.setNewword_uid(rs.getInt("newword_uid"));
				newword.setNewword_reviewtimes(rs.getInt("newword_reviewtimes"));
				newword.setNewword_forgettimes(rs.getInt("newword_forgettimes"));
				newword.setNewword_proficiency(rs.getInt("newword_proficiency"));
				newword.setNewword_modificationtime(rs.getString("newword_modificationtime"));
				newwordlist.add(newword); 
				}

		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return newwordlist; 
	}

	@Override
	public boolean addNewWord(NewWord newword) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="INSERT INTO newword(newword_wid, newword_uid, newword_reviewtimes, newword_forgettimes, "
					+ "newword_proficiency)"
					+ "values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newword.getNewword_wid());
			pstmt.setInt(2, newword.getNewword_uid());
			pstmt.setInt(3, newword.getNewword_reviewtimes());
			pstmt.setInt(4, newword.getNewword_forgettimes());
			pstmt.setInt(5, newword.getNewword_proficiency());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean deleteNewWord(Integer newword_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="DELETE FROM newword WHERE newword_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newword_id); 
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean updateNewWord(NewWord newword) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql = "UPDATE newword SET " +
					"newword_wid = ?, " +
					"newword_uid = ?, " +
                    "newword_reviewtimes = ?, " +
                    "newword_forgettimes = ?, " +
                    "newword_proficiency = ? " +
                    "WHERE newword_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newword.getNewword_wid());
			pstmt.setInt(2, newword.getNewword_uid());
			pstmt.setInt(3, newword.getNewword_reviewtimes());
			pstmt.setInt(4, newword.getNewword_forgettimes());
			pstmt.setInt(5, newword.getNewword_proficiency());
			pstmt.setInt(6, newword.getNewword_id());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public NewWord findNewWordById(Integer newword_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		NewWord newword = new NewWord();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT newword_id, newword_wid, newword_uid, newword_reviewtimes, newword_forgettimes, "
					+ "newword_proficiency, newword_modificationtime FROM newword WHERE newword_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newword_id); 
			rs = pstmt.executeQuery();
	        if (rs.next()) {
	        	newword.setNewword_id(rs.getInt("newword_id"));
				newword.setNewword_wid(rs.getInt("newword_wid"));
				newword.setNewword_uid(rs.getInt("newword_uid"));
				newword.setNewword_reviewtimes(rs.getInt("newword_reviewtimes"));
				newword.setNewword_forgettimes(rs.getInt("newword_forgettimes"));
				newword.setNewword_proficiency(rs.getInt("newword_proficiency"));
				newword.setNewword_modificationtime(rs.getString("newword_modificationtime"));
	        }
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return newword;
	}
	@Override
	public NewWord findNewWordByWidAndUid(Integer newword_wid,Integer newword_uid) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		NewWord newword = new NewWord();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT newword_id, newword_wid, newword_uid, newword_reviewtimes, newword_forgettimes, "
					+ "newword_proficiency, newword_modificationtime FROM newword WHERE newword_wid = ? AND newword_uid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newword_wid); 
			pstmt.setInt(2, newword_uid); 
			rs = pstmt.executeQuery();
	        if (rs.next()) {
	        	newword.setNewword_id(rs.getInt("newword_id"));
				newword.setNewword_wid(rs.getInt("newword_wid"));
				newword.setNewword_uid(rs.getInt("newword_uid"));
				newword.setNewword_reviewtimes(rs.getInt("newword_reviewtimes"));
				newword.setNewword_forgettimes(rs.getInt("newword_forgettimes"));
				newword.setNewword_proficiency(rs.getInt("newword_proficiency"));
				newword.setNewword_modificationtime(rs.getString("newword_modificationtime"));
	        }
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return newword;
	}

	@Override
	public List<NewWord> listNewWordByUid(Integer newword_uid) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<NewWord> newwordlist = new ArrayList<NewWord>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT newword_id, newword_wid, newword_uid, newword_reviewtimes, newword_forgettimes, "
					+ "newword_proficiency, newword_modificationtime FROM newword WHERE newword_uid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newword_uid); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NewWord newword = new NewWord();
				newword.setNewword_id(rs.getInt("newword_id"));
				newword.setNewword_wid(rs.getInt("newword_wid"));
				newword.setNewword_uid(rs.getInt("newword_uid"));
				newword.setNewword_reviewtimes(rs.getInt("newword_reviewtimes"));
				newword.setNewword_forgettimes(rs.getInt("newword_forgettimes"));
				newword.setNewword_proficiency(rs.getInt("newword_proficiency"));
				newword.setNewword_modificationtime(rs.getString("newword_modificationtime"));
				newwordlist.add(newword); 
				}
		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return newwordlist; 
	}
	
	@Override
	public List<NewWord> NewwordAndThesaurus(int newword_uid,String thesaurus_name) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<NewWord> newwordlist = new ArrayList<NewWord>();
		try {
			conn = DBUtils.getConnection();
			String sql = "SELECT newword_id, newword_wid, newword_uid, newword_reviewtimes, newword_forgettimes, "
					+ "newword_proficiency, newword_modificationtime FROM thesaurus as t, newword as n "
					+ "WHERE n.newword_wid = t.thesaurus_wid AND newword_uid = ? AND thesaurus_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, newword_uid);
			pstmt.setString(2, thesaurus_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NewWord newword = new NewWord();
				newword.setNewword_id(rs.getInt("newword_id"));
				newword.setNewword_wid(rs.getInt("newword_wid"));
				newword.setNewword_uid(rs.getInt("newword_uid"));
				newword.setNewword_reviewtimes(rs.getInt("newword_reviewtimes"));
				newword.setNewword_forgettimes(rs.getInt("newword_forgettimes"));
				newword.setNewword_proficiency(rs.getInt("newword_proficiency"));
				newword.setNewword_modificationtime(rs.getString("newword_modificationtime"));
				newwordlist.add(newword); 
				}
		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return newwordlist; 
	}
}


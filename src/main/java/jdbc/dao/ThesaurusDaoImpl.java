package jdbc.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.entity.NewWord;
import jdbc.entity.Thesaurus;
import jdbc.utils.DBUtils;

public class ThesaurusDaoImpl implements ThesaurusDao{

	@Override
	public List<Thesaurus> listAll() {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<Thesaurus> thesauruslist = new ArrayList<Thesaurus>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT thesaurus_id, thesaurus_wid, thesaurus_name, thesaurus_modificationtime "
					+ " FROM thesaurus";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Thesaurus thesaurus = new Thesaurus();
				thesaurus.setThesaurus_id(rs.getInt("thesaurus_id"));
				thesaurus.setThesaurus_wid(rs.getInt("thesaurus_wid"));
				thesaurus.setThesaurus_name(rs.getString("thesaurus_name"));
				thesaurus.setThesaurus_modificationtime(rs.getString("thesaurus_modificationtime"));
				thesauruslist.add(thesaurus); 
				}

		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return thesauruslist; 
	}

	@Override
	public boolean addThesaurus(Thesaurus thesaurus) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="INSERT INTO thesaurus(thesaurus_wid, thesaurus_name, thesaurus_modificationtime) "
					+ " values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, thesaurus.getThesaurus_wid());
			pstmt.setString(2, thesaurus.getThesaurus_name());
			pstmt.setString(3, thesaurus.getThesaurus_modificationtime());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean deleteThesaurus(Integer thesaurus_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="DELETE FROM thesaurus WHERE thesaurus_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, thesaurus_id); 
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean updateThesaurus(Thesaurus thesaurus) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql = "UPDATE thesaurus SET " +
					"thesaurus_wid = ?, " +
                    "thesaurus_name = ?, " +
                    "thesaurus_modificationtime = ?, " +
                    "WHERE thesaurus_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, thesaurus.getThesaurus_wid());
			pstmt.setString(2, thesaurus.getThesaurus_name());
			pstmt.setString(3, thesaurus.getThesaurus_modificationtime());
			pstmt.setInt(4, thesaurus.getThesaurus_id());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public Thesaurus findThesaurusById(Integer thesaurus_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		Thesaurus thesaurus = new Thesaurus();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT thesaurus_id, thesaurus_wid, thesaurus_name, thesaurus_modificationtime "
					+ " FROM thesaurus WHERE thesaurus_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, thesaurus_id); 
			rs = pstmt.executeQuery();
	        if (rs.next()) {
				thesaurus.setThesaurus_id(rs.getInt("thesaurus_id"));
				thesaurus.setThesaurus_wid(rs.getInt("thesaurus_wid"));
				thesaurus.setThesaurus_name(rs.getString("thesaurus_name"));
				thesaurus.setThesaurus_modificationtime(rs.getString("thesaurus_modificationtime"));
	        }
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return thesaurus;
	}


	@Override
	public List<Thesaurus> listThesaurusByName(String thesaurus_name) {

		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<Thesaurus> thesauruslist = new ArrayList<Thesaurus>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT thesaurus_id, thesaurus_wid, thesaurus_name, thesaurus_modificationtime "
					+ " FROM thesaurus WHERE thesaurus_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thesaurus_name); 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Thesaurus thesaurus = new Thesaurus();
				thesaurus.setThesaurus_id(rs.getInt("thesaurus_id"));
				thesaurus.setThesaurus_wid(rs.getInt("thesaurus_wid"));
				thesaurus.setThesaurus_name(rs.getString("thesaurus_name"));
				thesaurus.setThesaurus_modificationtime(rs.getString("thesaurus_modificationtime"));
				thesauruslist.add(thesaurus); 
				}

		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return thesauruslist; 
	}
	
	@Override
	public int countThesaurus(String thesaurus_name) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int count = 0 ;
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT count(*)  FROM thesaurus WHERE thesaurus_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thesaurus_name); 
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
				}
		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return count; 
	}

}

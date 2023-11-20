package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import jdbc.entity.User;
import jdbc.utils.DBUtils;

public class UserDaoImpl implements UserDao{
	
	@Override
	public boolean login(String userEmail, String userPassword) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int flg = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT user_id, user_name, user_email, user_password, user_pepdom "
					+ "FROM users WHERE user_email = ? AND user_password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail); 
			pstmt.setString(2, userPassword);
			rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	flg = 1;
	        }
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return flg > 0;
	}
	
	@Override
	public boolean register(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int flg = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="INSERT INTO users(user_name, user_email, user_password, user_pepdom)"
					+ "values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_email());
			pstmt.setString(3, user.getUser_password());
			pstmt.setString(4, user.getUser_pepdom());
			rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	flg = 1;
	        }
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return flg > 0;
	}

	@Override
	public List<User> listAll() {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		List<User> userlist = new ArrayList<User>();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT user_id, user_name, user_email, user_password, user_pepdom FROM users";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name")); 
				user.setUser_email(rs.getString("user_email")); 
				user.setUser_password(rs.getString("user_password")); 
				user.setUser_pepdom(rs.getString("user_pepdom"));  
				userlist.add(user); 
				}

		}catch (SQLException se) {
			se.printStackTrace();
		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return userlist; 
	}

	@Override
	public boolean adduser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="INSERT INTO users(user_name, user_email, user_password, user_pepdom)"
					+ "values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_email());
			pstmt.setString(3, user.getUser_password());
			pstmt.setString(4, user.getUser_pepdom());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean deleteuser(Integer user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql ="DELETE FROM users WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_id); 
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public boolean updateuser(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		int rows = 0;
		try {
			conn = DBUtils.getConnection();
			String sql = "UPDATE users SET " +
					"user_name = ?, " +
					"user_email = ?, " +
                    "user_password = ?, " +
                    "user_pepdom = ?, " +
                    "WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUser_name());
			pstmt.setString(2, user.getUser_email());
			pstmt.setString(3, user.getUser_password());
			pstmt.setString(4, user.getUser_pepdom());
			rows = pstmt.executeUpdate();
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return rows > 0;
	}

	@Override
	public User finduserById(Integer user_id) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		User user = new User();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT user_id, user_name, user_email, user_password, user_pepdom"
					+ "FROM users WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user_id); 
			rs = pstmt.executeQuery();

	        if (rs.next()) {
	            user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name")); 
				user.setUser_email(rs.getString("user_email")); 
				user.setUser_password(rs.getString("user_password")); 
				user.setUser_pepdom(rs.getString("user_pepdom"));  
	        }
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return user;
	}
	
	@Override
	public User finduserByEmail(String user_email) {
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		User user = new User();
		try {
			conn = DBUtils.getConnection();
			String sql ="SELECT user_id, user_name, user_email, user_password, user_pepdom "
					+ "FROM word_db.users WHERE user_email = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_email); 
			rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	user.setUser_id(rs.getInt("user_id")); 
				user.setUser_name(rs.getString("user_name")); 
				user.setUser_email(rs.getString("user_email")); 
				user.setUser_password(rs.getString("user_password")); 
				user.setUser_pepdom(rs.getString("user_pepdom"));  
	        }
	        System.out.print(user.getUser_name()+"!");
		}catch (SQLException se) {
			se.printStackTrace();

		}finally { 
			DBUtils.destroy(conn, pstmt, rs);
		}
		return user;
	}
}

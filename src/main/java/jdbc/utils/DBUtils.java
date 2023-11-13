package jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private DBUtils() {
	}

	/**
	 * �������ݿ�����
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() {
		Connection conn = null;
		// ���ز�ע��JDBC�����ʹ������ݿ����ӻ�����쳣
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/word_db";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر����ݿ�����
	 * 
	 * @param rs�����������
	 * @param pstmt��ִ��SQL��Statement����������β���Statement���ͣ���ΪPrepareStatement��Statement���ӽӿڣ����Ե�ʵ����PrepareStatement���͵�ʱ��Ҳû���⡣
	 * @param conn�����Ӷ���
	 */
	public static void destroy(Connection conn, Statement pstmt, ResultSet rs) {
		try {
			if (rs != null) // ���rs != null������rs��ʵ�����ˣ����������Ҫ�ر�һ�£������ͷţ�
				rs.close();

			if (pstmt != null) // ���pstmt != null������pstmt��ʵ�����ˣ����������Ҫ�ر�һ�£������ͷţ�
				pstmt.close();

			if (conn != null)
				conn.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}


/* public class WordDAOImpl {
	private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/word_db?verifyServerCertificate=false&useSSL=false&serverTimezone=GMT%2B8";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
}
*/
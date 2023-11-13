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
	 * 创建数据库连接
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() {
		Connection conn = null;
		// 加载并注册JDBC驱动和创建数据库连接会产生异常
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
	 * 关闭数据库连接
	 * 
	 * @param rs：结果集对象；
	 * @param pstmt：执行SQL的Statement对象；这儿的形参是Statement类型，因为PrepareStatement是Statement的子接口，所以当实参是PrepareStatement类型的时候也没问题。
	 * @param conn：连接对象；
	 */
	public static void destroy(Connection conn, Statement pstmt, ResultSet rs) {
		try {
			if (rs != null) // 如果rs != null，代表rs被实例化了，所以这儿需要关闭一下，进行释放；
				rs.close();

			if (pstmt != null) // 如果pstmt != null，代表pstmt被实例化了，所以这儿需要关闭一下，进行释放；
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
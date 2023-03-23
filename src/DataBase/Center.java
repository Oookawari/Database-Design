package DataBase;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Center {
	protected static Connection conn=null;
	protected static Statement stmt=null;
	protected static Center instance = null;
	protected static ResultSet rs = null;
	private static Center getInstance() {
		if(instance == null) {
			instance = new Center();
		}
		return instance;
	}
	protected static Center getCenter() {
		return Center.getInstance();
	}
	private Center() {;
		try {
			//第一步 注册驱动
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//第二步 获取连接
			String url="jdbc:mysql://localhost:3306/eshoppingdb";
			String user="root";
			String password="lyh13708404609";
			conn= DriverManager.getConnection(url, user, password);
			
			 System.out.println("数据库连接对象"+conn);		
			//第三步获取数据库操作对象
			 stmt =conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected static void destroy() {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    	if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	return;
	}

	protected static int insert(String tables, String values) {
		String sql = new String("INSERT " + tables + " VALUES " + values + ";");
		System.out.println(sql);
		int count = 0;
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		return count;
	}
	protected static int delete(String tables, String values) {
		String sql = new String("delete from " + tables + " where " + values + ";");
		int count = 0;
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	protected static int update(String tables, String values, String condition) {
		String sql = new String("UPDATE " + tables + " SET " + values + " WHERE " + condition + ";");
		int count = 0;
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	protected static int select(String arr, String tables, String condition) {
		String sql = new String("SELECT " + arr + " FROM " + tables + " WHERE " + condition + ";");
		int count = 0;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	protected static int customize1(String sql) {
		int count = 0;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	protected static int customize2(String sql) {
		int count = 0;
		try {
			count = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
}

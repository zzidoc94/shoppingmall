package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	static {

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cne){
			System.out.println("드라이버 로딩 실패");
			cne.printStackTrace();
		}
	}//static End
	
	public static Connection getConnection() {
		Connection con=null;
		try{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"icia", "1111");
			System.out.println("Connection Success!");

		}
		catch(SQLException se){
			se.printStackTrace();
		}
		return con;
	} //getConnection End

public static void close(ResultSet rs, PreparedStatement stmt, Connection con) {
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			System.out.println("close 에러");
			e.printStackTrace();
		}
		System.out.println("close ok");
	}//close End


}

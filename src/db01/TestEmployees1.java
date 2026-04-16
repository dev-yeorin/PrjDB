package db01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestEmployees1 {

	
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url 	 = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static String dbuid  = "hr";
	private static String dbpwd  = "1234";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName( driver );
		Connection  conn = DriverManager.getConnection(url, dbuid, dbpwd);
		
		Statement 	stmt = conn.createStatement();
		String 		 sql = 
				"SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, PHONE_NUMBER"
				+ " FROM EMPLOYEES ";
			
		System.out.println(sql);
		ResultSet 	 rs  = stmt.executeQuery(sql);
		
		while ( rs.next() != false ) {
			System.out.print(rs.getString(1) + ", ");
			System.out.print(rs.getString(2) + " ");
			System.out.print(rs.getString(3) + ", ");
			System.out.print(rs.getString(4) + ", ");
			System.out.println();
			       

			
		}
		stmt.close();
		conn.close();
	}

}

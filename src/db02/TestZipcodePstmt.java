package db02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestZipcodePstmt {
	
	// db 연결 문자열
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url	 = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid	 = "hr";
	private static String dbpwd	 = "1234";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName( driver );
		Connection	conn = DriverManager.getConnection(url, dbuid, dbpwd);
		//System.out.println( conn );
		
		String			  sql	= "";
		sql  += " SELECT NVL(D.DEPARTMENT_NAME, '부서없음') 부서명,";
		sql  += " E.FIRST_NAME || ' ' || E.LAST_NAME 직원명,";
		sql  += " E.PHONE_NUMBER 직원전화";
		sql  += " FROM   DEPARTMENTS D RIGHT JOIN EMPLOYEES E ";
		sql	 += " ON D.DEPARTMENT_ID = E.DEPARTMENT_ID ";
		sql  += " WHERE D.DEPARTMENT_ID = 80";
		System.out.println(sql);
		PreparedStatement pstmt = conn.prepareStatement( sql );
		pstmt.setInt( 1, 80 ); // 첫번째 ? 의 값을 설정
		
		ResultSet		  rs    = pstmt.executeQuery();
		String			  fmt   = "%s %s %s";
		
		while(rs.next()  ) {
			String dname = rs.getString("부서명");
			String ename = rs.getString("직원명");
			String tel   = rs.getString("직원전화");
			String msg = String.format(fmt, dname, ename, tel);
			System.out.println( msg );
			
		}
		
		conn.close();
		
	}

}
// 변수명.next() != null, false / 변수명.next() == true 의미 동일
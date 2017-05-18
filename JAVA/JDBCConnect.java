package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnect {
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결성공!");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@127.0.0.1:1521:Orcl", // DB url
					"temp", //user
					"1234"); //password
			System.out.println("DB 연결 성공!");
			
			stmt = conn.createStatement();
			//stmt.executeUpdate("insert into tb values('5555555', '길동', '몰라')");  // DB 내용 추가
			//stmt.executeUpdate("delete from tb where name='홍길동'");               // DB 내용 삭제 
			rs = stmt.executeQuery("select * from tb");
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				System.out.println(id + "\t" + name + "\t" + dept);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결실패!");
		} catch (SQLException e) {
			System.out.println("접속실패! 주소, 아이디, 패스워드 체크!");
			e.printStackTrace();
		}
		
	}

}

package jdbcconnect;

import java.sql.*;

public class ConnectionExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1. JDBC Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Ok!");

			//연결하기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "4245");

			//매개변수화된 SQL문 작성
			String sql = "insert into users(usersid, username, userpassword, userage, useremail)" +
					"values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"ssg");
			pstmt.setString(2,"신세계");
			pstmt.setString(3,"1234");
			pstmt.setInt(4,30);
			pstmt.setString(5,"ssg@gmail.com");
			//sql문 실행
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수 : "+rows);

			pstmt.close();

//			Statement stmt = conn.createStatement();
//			String sql = "select * from buytbl";
//			ResultSet resultSet = stmt.executeQuery(sql);
//
//			while(resultSet.next()) {
//				System.out.println(resultSet.getString("prodName"));
//			}
//			resultSet.close();
//			stmt.close();

			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					//3. 연결 끊기
					conn.close();



					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
	}
}
package jdbcconnect;

import java.sql.*;

public class UserSelectExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//1. JDBC Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Ok!");

			//연결하기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "4245");

			//매개변수화된 SQL문 작성
			String sql = "select usersid, username, userpassword, userage, useremail"+
					"from users" +
					"where usersid = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"ssg");

			//sql문 실행
			ResultSet rs = pstmt.executeQuery(sql);
			if (rs.next()){
				User user = new User();

				user.setUsersid(rs.getString("usersid"));
				user.setUserpassword(rs.getString("userpassword"));
				user.setUsername(rs.getString("username"));
				user.setUserage(rs.getInt("userage"));
				user.setUseremail(rs.getString("useremai"));
				System.out.println(user);
			}else{
				System.out.println("사용자 아이디가 존재하지 않습니다.");
			}

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
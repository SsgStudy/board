package jdbcconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MulitUserSelectExample {
	public static void main(String[] args) {
		Connection conn = null;
		List<User> userList = new ArrayList<>();
		try {
			//1. JDBC Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Ok!");

			//연결하기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "4245");

			//매개변수화된 SQL문 작성
			String sql = "select *"+
					"from users";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			//sql문 실행
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUsersid(rs.getString("usersid"));
				user.setUserpassword(rs.getString("userpassword"));
				user.setUsername(rs.getString("username"));
				user.setUserage(rs.getInt("userage"));
				user.setUseremail(rs.getString("useremail"));
//				System.out.println(user);
				userList.add(user);
			}

			rs.close();
			for (User user : userList){
				System.out.println(user);
			}


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
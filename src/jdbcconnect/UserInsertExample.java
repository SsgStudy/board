//package jdbcconnect;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class UserInsertExample {
//	public static void main(String[] args) {
//		Connection conn = null;
//		try {
//			//JDBC Driver 등록
//
//
//			//연결하기
//
//
//			//매개변수화된 SQL문 작성
//            String sql = "insert into users(usersid, username, userpassword, userage, useremail)"+
//                    "values(?,?,?,?,?)";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,"ssg");
//            pstmt.setString(2,"ssg");
//            pstmt.setString(3,"ssg");
//            pstmt.setInt(4,25);
//            pstmt.setString(5,"ssg");
//			//PreparedStatement 얻기 및 값 지정
//
//			//SQL문 실행
//
////			System.out.println("저장된 행 수: " + rows);
//
//			//PreparedStatement 닫기
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if(conn != null) {
//				try {
//					//연결 끊기
//
//
//				} catch (SQLException e) {}
//			}
//		}
//	}
//}

package jdbcconnect;

import java.io.FileInputStream;
import java.sql.*;

public class BoardUpdateExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sqldb",
                    "root",
                    "4245"
            );

            //매개변수화된 SQL문 작성
            String sql = new StringBuilder().append("update boards set ")
                    .append("bfilename = ? ")
                    .append(",bfiledata = ? ")
                    .append("where bno = ? ").toString();

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, "눈사람");
            pstmt.setBlob(2, new FileInputStream("chrismas.jpg"));
            pstmt.setInt(3, 1);

            //SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수: " + rows);

            //bno 값 얻기
//            if (rows == 1) {
//                ResultSet rs = pstmt.getGeneratedKeys(); // bno 컬럼의 값을 리턴받는다.
//                if (rs.next()) {
//                    int bno = rs.getInt(1);
//                    System.out.println("bno : " + bno);
//                }
//                rs.close();
//            }

            //PreparedStatement 닫기
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    //연결 끊기
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}




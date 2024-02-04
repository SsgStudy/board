package jdbcconnect;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MulitBoardSelectExample {
	public static void main(String[] args) throws Exception{
		Connection conn = null;
		ArrayList<Board> boardList = new ArrayList<Board>();
		try {
			//1. JDBC Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Ok!");

			//연결하기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sqldb", "root", "4245");

			//매개변수화된 SQL문 작성
			String sql = new StringBuilder().append("select * from boards").toString();

			PreparedStatement pstmt = conn.prepareStatement(sql);

			//sql문 실행
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				boardList.add(board);

				//파일 저장(다운로드)
				Blob blob = board.getBfiledata();
				if (blob != null){
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("C://Temp/"+board.getBfilename());
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();

				}
			}
			rs.close();
			for (Board board : boardList){
				System.out.println(board);
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
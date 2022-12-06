package ex;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		try {
			// 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. DB 연결 > Connction
			String url = "jdbc:oracle:thin:@10.200.200.94:1521:xe";
			String user = "USER01";
			String pwd = "webgis12!";

			Connection con = DriverManager.getConnection(url, user, pwd);

			// 3. SQL문 작성(예시)
			String sql = "INSERT INTO TN_MS_MUSIC_TEST (MUSIC_NO,ALBUM_NO,ARTIST_NO,MUSIC_TITLE,MUSIC_LYRICS"
					+ ",MUSIC_COMPOSITION,MUSIC_WRITE,MUSIC_ARRANGE,MUSIC_GENRE,MUSIC_LIKE,MUSIC_PLAYCOUNT,MUSIC_MV"
					+ ",MUSIC_ADULT,MUSIC_FILE,MUSIC_ALBUMORDER) VALUES (225,47,24,'비밀번호 486','윤하 가사','윤하','윤하'"
					+ ",'윤하',3,0,0, EMPTY_BLOB(),'0','음악 파일',5)";

			// 4. sql문을 실행시키기위한 Statement 객체 얻음
			Statement stmt = con.createStatement();

			// 5. Statement의 execute(String sql) 메소드를 이용해서 sql문 실행
			stmt.execute(sql);

			// 6. DB연결 자원 반납
			if (stmt != null) stmt.close();
			if (con != null) con.close();

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

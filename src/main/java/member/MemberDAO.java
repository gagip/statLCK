package member;

import static util.DBUtil.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import base.DAOBase;

public class MemberDAO extends DAOBase {
	
	private static MemberDAO instance;
	
	private MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 실패");
		}
		
		try {
			conn = DriverManager.getConnection(URL, USERID, PASSWORD);
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
	}
	
	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}
	
	public void insert(String id, String pw, String name, String email,
						String address, String tel, String pImage) {
		String sql = "INSERT INTO Member (member_num, id, pw, name, email, address, tel, p_image) "
					+ "				VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNum("Member", "member_num", conn));
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, name);
			pstmt.setString(5, email);
			pstmt.setString(6, address);
			pstmt.setString(7, tel);
			pstmt.setString(8, pImage);
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO - 회원가입 실패");
			e.printStackTrace();
		}
		
		close(pstmt);
	}
	
	public void update(String id, String pw, String name, String email,
					String address, String tel, String pImage) {
		String sql = "UPDATE Member SET pw=? "
					+ "WHERE id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
	}
}

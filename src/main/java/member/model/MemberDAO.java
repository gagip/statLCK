package member.model;

import static util.DBUtil.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DAOBase;
import member.LoginState;



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
	
	
	
	/**
	 * 회원 가입
	 */
	public void addMember(MemberDTO member) {
		String sql = "INSERT INTO Member (member_num, id, pw, name, email, address, tel, p_image) "
					+ "				VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNum("Member", "member_num", conn));
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPw());
			pstmt.setString(4, member.getName());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getAddress());
			pstmt.setString(7, member.getTel());
			pstmt.setString(8, member.getpImage());
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO - 회원가입 실패");
			e.printStackTrace();
		}
		
		close(pstmt);
	}
	
	
	/**
	 * 로그인
	 * @param id
	 * @param pw
	 * @return 1=로그인 성공; 0=비밀번호 불일치; -1=존재하지 않는 아이디;
	 */
	public LoginState login(String id, String pw) {
		String sql = "SELECT id, pw FROM Member WHERE id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String dbPw = rs.getString("pw");
				if (dbPw.equals(pw)) {
					// 로그인 성공
					return LoginState.SUCCESS;
				}
				else {
					System.out.println("MemberDAO - 비밀번호 일치하지 않음");
					return LoginState.PW_MISMATCH;
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - 로그인 실패");
		}
		
		
		System.out.println("MemberDAO - 존재하지 않는 아이디");
		return LoginState.NON_EXIST_ID;
	}
	
	
	/**
	 * Member 회원 정보 업데이트
	 */
	public void updateMember(MemberDTO member) {
		String sql = "UPDATE Member SET pw=?, name=?, email=?, address=?, tel=?,"
									+ " p_image=? update_date=SYSDATE "
					+ "WHERE id=?";
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getTel());
			pstmt.setString(6, member.getpImage());
			pstmt.setString(7, member.getId());
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO - 회원정보 업데이트 실패");
			e.printStackTrace();
		}
		
		close(pstmt);
	}

	
	/**
	 * 회원 리스트 조회
	 * @return
	 */
	public ArrayList<MemberDTO> getMembers(){
		ArrayList<MemberDTO> members = new ArrayList<MemberDTO>();
		
		String sql = "SELECT * FROM Member ORDER BY create_date DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setTel(rs.getString("tel"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setpImage(rs.getString("p_image"));
				member.setCreateDate(rs.getDate("create_date"));
				member.setUpdateDate(rs.getDate("update_date"));
				member.setMember_num(rs.getInt("member_num"));
				
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - 회원리스트 조회 실패");
		}
		
		close(rs);
		close(pstmt);
		return members;
	}
	
	
	/**
	 * 회원 탈퇴
	 * @param id
	 */
	public void delMember(String id) {
		String sql = "DELETE FROM Member WHERE id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDAO - 회원 탈퇴 실패");
		}
		
	}
}
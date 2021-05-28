package board.model;

import static util.DBUtil.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DAOBase;

public class BoardDAO extends DAOBase {
private static BoardDAO instance;
	
	private BoardDAO() {
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
	
	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}
	
	
	/**
	 * 게시글 쓰기
	 * @param board
	 */
	public void insertBoard(BoardDTO board, int member_num) {
		String sql = "INSERT INTO Board (board_num, title, cate, member_num, content) "
				    + 			"VALUES (?, ?, ?, ?, ?) ";
		
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, getNum("Board", "board_num", conn));
			pstmt.setString(2, board.getTitle());
			pstmt.setInt(3, board.getCate());
			pstmt.setInt(4, member_num);
			pstmt.setString(5, board.getContent());
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO - 게시글 쓰기 실패");
			rollback(conn);
		}
		
		close(pstmt);
	}
	
	
	/**
	 * 게시글 삭제
	 * @param boardNum
	 */
	public void deleteBoard(int boardNum) {
		String sql = "DELETE FROM Board WHERE board_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);
			
			if (pstmt.executeUpdate() > 0) {
				commit(conn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO - 게시글 삭제 실패");
			rollback(conn);
		}
		
		close(pstmt);
	}
	
	
	/**
	 * 게시글 조회
	 * @param boardNum
	 * @return
	 */
	public BoardDTO getBoard(int boardNum) {
		BoardDTO board = null;
		String sql = "SELECT Board.*, Member.id AS author "
					+ "FROM Board LEFT JOIN Member "
					+ "ON Board.member_num=Member.member_num "
					+ "WHERE board_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new BoardDTO();
				board.setBoardNum(rs.getInt("board_num"));
				board.setTitle(rs.getString("title"));
				board.setCate(rs.getInt("cate"));
				board.setAuthor(rs.getString("author"));
				board.setLikeCnt(rs.getInt("like_cnt"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setPubDate(rs.getDate("pub_date"));
				board.setModDate(rs.getDate("mod_date"));
				board.setContent(rs.getString("content"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO - 게시글 조회 실패");
		}
		
		close(pstmt);
		return board;
	}
	
	
	
	/**
	 * 게시글 전체 조회
	 * @return
	 */
	public ArrayList<BoardDTO> getBoardList() {
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		String sql = 	"SELECT Board.*, Member.id AS author "
					+ 	"FROM Board LEFT JOIN Member "
					+ 	"ON Board.member_num=Member.member_num "
					+ 	"ORDER BY Board.pub_date DESC";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBoardNum(rs.getInt("board_num"));
				board.setTitle(rs.getString("title"));
				board.setCate(rs.getInt("cate"));
				board.setAuthor(rs.getString("author"));
				board.setLikeCnt(rs.getInt("like_cnt"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setPubDate(rs.getDate("pub_date"));
				
				boardList.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BoardDAO - 게시글 전체 조회 실패");
		}
		
		close(rs);
		close(pstmt);
		return boardList;
	}
}

package board.model;


import java.util.ArrayList;
import java.util.HashMap;
import base.DAOBase;
import util.DBConnection;

public class BoardDAO extends DAOBase {
private static BoardDAO instance;
	
	private BoardDAO() {
	}
	
	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}
	
	
	public int getSeq() {
		int result = 1;
		String sql = "SELECT board_num_seq.NEXTVAL FROM DUAL";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			if (rs.next())		result = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return result;
	}
	
	
	/**
	 * 게시글 쓰기
	 * @param board
	 */
	public boolean insertBoard(BoardDTO board, int member_num) {
		boolean result = false;
		String sql = "INSERT INTO Board (board_num, title, cate, member_num, content) "
				    + 			"VALUES (?, ?, ?, ?, ?) ";
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board.getBoardNum());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getCate());
			pstmt.setInt(4, member_num);
			pstmt.setString(5, board.getContent());
			
			if (pstmt.executeUpdate() > 0) {
				result = true;
				commit();
			} 
			
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			System.out.println("BoardDAO - 게시글 쓰기 실패");
			
		}
		
		close();
		return result;
	}
	
	
	
	public boolean updateBoard(BoardDTO board) {
		boolean result = false;
		String sql = 	"UPDATE Board "
					+	"SET title = ?, cate =?, content = ?, mod_date=SYSDATE "
					+ 	"WHERE board_num = ?";
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getCate());
			pstmt.setString(3, board.getContent());
			pstmt.setInt(4, board.getBoardNum());
			
			if (pstmt.executeUpdate() > 0) {
				result = true;
				commit();
			}
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		
		
		close();
		return result;
	}
	
	
	/**
	 * 게시글 삭제
	 * @param boardNum
	 */
	public boolean deleteBoard(int boardNum) {
		String sql = "DELETE FROM Board WHERE board_num=?";
		boolean result = false;
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);
			
			if (pstmt.executeUpdate() > 0) {
				result = true;
				commit();
			}
			
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
			System.out.println("BoardDAO - 게시글 삭제 실패");
		}
		
		
		close();
		return result;
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
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNum);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new BoardDTO();
				board.setBoardNum(rs.getInt("board_num"));
				board.setTitle(rs.getString("title"));
				board.setCate(rs.getString("cate"));
				board.setAuthor(rs.getString("author"));
				board.setLikeCnt(rs.getInt("like_cnt"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setPubDate(rs.getDate("pub_date"));
				board.setModDate(rs.getDate("mod_date"));
				board.setContent(rs.getString("content"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("BoardDAO - 게시글 조회 실패");
		}
		
		close();
		return board;
	}
	
	
	
	/**
	 * 게시글 전체 조회
	 * @return
	 */
	public ArrayList<BoardDTO> getBoardList(HashMap<String, Object> listOpt) {
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		
		String opt = (String) listOpt.get("opt");
		String condition = (String) listOpt.get("condition");
		int start = (Integer) listOpt.get("start");
		
		try {
			conn = DBConnection.getConnection();
			if (opt == null) {
				String sql = 	"SELECT * "
							+ 	"FROM	(SELECT ROW_NUMBER() OVER (ORDER BY Board.pub_date DESC) AS rnum, "
							+ 	"				Board.*, Member.id AS author "
							+ 	"		FROM Board LEFT JOIN Member "
							+ 	"		ON Board.member_num=Member.member_num) "
							+ 	"WHERE ?<=rnum AND rnum<=? ";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, start+9);
			} else if (opt.equals("0")) {	// 제목
				String sql = 	"SELECT * "
							+ 	"FROM 	(SELECT ROW_NUMBER() OVER (ORDER BY Board.pub_date DESC) AS rnum, "
							+ 	"				Board.*, Member.id AS author "
							+ 	"		FROM Board LEFT JOIN Member "
							+ 	"		ON Board.member_num=Member.member_num "
							+ 	"		WHERE Board.title LIKE ?) "
							+ 	"WHERE ?<=rnum AND rnum<=?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			} else if (opt.equals("1")) {	// 글쓴이 아이디
				String sql = 	"SELECT * "
							+ 	"FROM 	(SELECT ROW_NUMBER() OVER (ORDER BY Board.pub_date DESC) AS rnum,"
							+ 	"		Board.*, Member.id AS author "
							+ 	"		FROM Board LEFT JOIN Member "
							+ 	"		ON Board.member_num=Member.member_num "
							+ 	"		WHERE Member.id LIKE ?) "
							+ 	"WHERE ?<=rnum AND rnum<=?";
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			} else if (opt.equals("2")) {	// 내용
				String sql = 	"SELECT * "
						+ 	"FROM 	(SELECT ROW_NUMBER() OVER (ORDER BY Board.pub_date DESC) AS rnum, "
						+ 	"		Board.*, Member.id AS author "
						+ 	"		FROM Board LEFT JOIN Member "
						+ 	"		ON Board.member_num=Member.member_num "
						+ 	"		WHERE Board.content LIKE ?) "
						+ 	"WHERE ?<=rnum AND rnum<=?";
		
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, start+9);
			} else if (opt.equals("3")) {	// 제목 + 내용
					String sql = 	"SELECT * "
							+ 	"FROM 	(SELECT ROW_NUMBER() OVER (ORDER BY Board.pub_date DESC) AS rnum,"
							+ 	"		Board.*, Member.id AS author "
							+ 	"		FROM Board LEFT JOIN Member "
							+ 	"		ON Board.member_num=Member.member_num "
							+ 	"		WHERE Board.title LIKE ? OR Board.content LIKE ?) "
							+ 	"WHERE ?<=rnum AND rnum<=?";
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
				pstmt.setInt(3, start);
				pstmt.setInt(4, start+9);
			}
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setBoardNum(rs.getInt("board_num"));
				board.setTitle(rs.getString("title"));
				board.setCate(rs.getString("cate"));
				board.setAuthor(rs.getString("author"));
				board.setLikeCnt(rs.getInt("like_cnt"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setPubDate(rs.getDate("pub_date"));
				
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("BoardDAO - 게시글 전체 조회 실패");
		}


		close();
		return boardList;
	}
	
	
	/**
	 * 게시글 리스트 길이 조회
	 * @param listOpt
	 * @return
	 */
	public int getBoardListLength(HashMap<String, Object> listOpt) {
		int result = 0;
		String opt = (String) listOpt.get("opt");
		String condition = (String) listOpt.get("condition");
		
		try {
			conn = DBConnection.getConnection();
			if (opt == null) {
				String sql = "SELECT COUNT(*) FROM Board";
				
				pstmt = conn.prepareStatement(sql);
			} else if (opt.equals("0")) {
				String sql = 	"SELECT COUNT(*) "
							+ "	FROM Board "
							+ "	WHERE title LIKE ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
			} else if (opt.equals("1")) {
				String sql =	"SELECT COUNT(*) "
							+ "	FROM Board LEFT JOIN Member "
							+ "	ON Board.member_num=Member.member_num "
							+ " WHERE Member.id LIKE ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
			} else if (opt.equals("2")) {
				String sql = 	"SELECT COUNT(*) "
							+ "	FROM Board "
							+ " WHERE content LIKE ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
			} else if (opt.equals("3")) {
				String sql =	"SELECT COUNT(*) "
							+ "	FROM Board LEFT JOIN Member "
							+ "	ON Board.member_num=Member.member_num "
							+ " WHERE Member.id LIKE ? OR Board.title LIKE ? ";
			
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+condition+"%");
				pstmt.setString(2, "%"+condition+"%");
			}
			
			rs = pstmt.executeQuery();
			if (rs.next())		result = rs.getInt(1); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		close();
		return result;
	}
	
	
	
	/**
	 * 조회수 증가
	 * @param boardNum
	 * @return
	 */
	public boolean updateViewCount(int boardNum) {
		boolean result = false;
		String sql = 	"UPDATE Board SET view_cnt=view_cnt+1 "
					+ 	"WHERE board_num=? ";
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			if (pstmt.executeUpdate()>0) {
				result = true;
				commit();
			}
		} catch (Exception e) {
			rollback();
			e.printStackTrace();
		}
		
		close();
		return result;
	}
}	

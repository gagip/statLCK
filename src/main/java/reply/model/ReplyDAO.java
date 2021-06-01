package reply.model;


import java.util.ArrayList;

import base.DAOBase;
import util.DBConnection;

public class ReplyDAO extends DAOBase {
	private static ReplyDAO instance = null;
	
	private ReplyDAO() {}
	
	public static ReplyDAO getInstance() {
		if (instance == null)
			instance = new ReplyDAO();
		return instance;
	}
	
	public int getSeq() {
		int result = 1;
		String sql = "SELECT reply_num_seq.NEXTVAL FROM DUAL ";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next())		result=rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		close();
		return result;
	}
	
	
	public boolean insertReply(ReplyDTO reply) {
		boolean result = false;
		String sql = 	"INSERT INTO Reply (reply_num, board_num, member_num, rpy_parent_num, content) "
					+ 	"VALUES (?, ?, ?, ?, ?)";
		
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reply.getReplyNum());
			pstmt.setInt(2, reply.getBoardNum());
			pstmt.setInt(3, reply.getMemberNum());
			pstmt.setInt(4, reply.getRpyParentNum());
			pstmt.setString(5, reply.getContent());
			
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
	
	
	public ArrayList<ReplyDTO> getReplyList(int boardNum) {
		ArrayList<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		String sql = 	"SELECT  LEVEL, Sub.* "
					+ 	"FROM    (SELECT Reply.*, Member.id AS author "
					+ 	"        FROM Reply LEFT JOIN Member "
					+ 	"        ON Reply.member_num=Member.member_num "
					+ 	"        WHERE board_num=?) Sub "
					+ 	"START WITH rpy_parent_num=0 "
					+ 	"CONNECT BY PRIOR reply_num=rpy_parent_num";
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReplyDTO replyDTO = new ReplyDTO();
				replyDTO.setReplyNum(rs.getInt("reply_num"));
				replyDTO.setBoardNum(rs.getInt("board_num"));
				replyDTO.setMemberNum(rs.getInt("member_num"));
				replyDTO.setAuthor(rs.getString("author"));
				replyDTO.setPubDate(rs.getDate("pub_date"));
				replyDTO.setModDate(rs.getDate("mod_date"));
				replyDTO.setRpyParentNum(rs.getInt("rpy_parent_num"));
				replyDTO.setContent(rs.getString("content"));
				
				replyList.add(replyDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		close();
		return replyList;
	}
}

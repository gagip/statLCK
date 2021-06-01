package reply.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import member.PointManager;
import reply.model.ReplyDAO;
import reply.model.ReplyDTO;

public class ReplyWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		String id = (String) request.getSession().getAttribute("sessionId");
		int memberNum = (int) request.getSession().getAttribute("sessionMemberNum");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String content = request.getParameter("content");
		
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		ReplyDTO reply = new ReplyDTO();
		reply.setReplyNum(replyDAO.getSeq());
		reply.setAuthor(id);
		reply.setMemberNum(memberNum);
		reply.setBoardNum(boardNum);
		reply.setContent(content);
		
		boolean result = replyDAO.insertReply(reply);
		if(result) {
			// 포인트 얻기
			PointManager pm = PointManager.getInstance();
			pm.addPoint(memberNum, PointManager.REPLY_WRITE_POINT);
			
			// 더미
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("");
			out.close();
		}
		
		return null;
	}
	
}

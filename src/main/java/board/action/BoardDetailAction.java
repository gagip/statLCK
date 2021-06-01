package board.action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;
import board.model.BoardDTO;
import reply.model.ReplyDAO;
import reply.model.ReplyDTO;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String strNum = request.getParameter("boardNum");
		int num = Integer.parseInt(strNum);
		String pageNum = request.getParameter("pageNum");
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		// 쿠키를 확인하여 조회수 체크
		boolean isCookie = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies)
				if (c.getName().equals("B"+strNum)) isCookie = true;
			
			// 쿠키에 해당 정보가 없는 경우
			if (!isCookie) {
				boolean result = boardDAO.updateViewCount(num);
				if (result) {
					Cookie c1 = new Cookie("B"+strNum, "view");
					c1.setMaxAge(1*24*60*60); // 하루 저장
					response.addCookie(c1);
				}
			}
		}
		BoardDTO board = boardDAO.getBoard(num);
		
		// 댓글 가져오기
		ReplyDAO replyDAO = ReplyDAO.getInstance();
		ArrayList<ReplyDTO> replyList = replyDAO.getReplyList(num);
		if (replyList.size() > 0)	request.setAttribute("replyList", replyList);
		
		request.setAttribute("board", board);
		request.setAttribute("pageNum", pageNum);
		
		forward.setRedirect(false);
		forward.setNextPath("board_detail.bo");
		
		
		return forward;
	}
}

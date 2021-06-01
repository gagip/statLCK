package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String sessionId = (String) request.getSession().getAttribute("sessionId");
		
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO board = boardDAO.getBoard(boardNum);
		
		// 아이디와 글쓴이 아이디 비교
		if (board.getAuthor().equals(sessionId)) {
			request.setAttribute("board", board);
			
			forward.setRedirect(false);
			forward.setNextPath("board_write.bo");
		} else {
			request.setAttribute("fail", "auth");
			
			forward.setRedirect(false);
			forward.setNextPath("boardListAction.bo");
		}
		
		
		
		return forward;
	}
	
}

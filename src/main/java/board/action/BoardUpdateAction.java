package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO board = boardDAO.getBoard(boardNum);
		boolean result = boardDAO.updateBoard(board);
		
		if (result) {
			forward.setRedirect(true);
			forward.setNextPath("boardDetailAction.bo?boardNum="+boardNum);
		}
		
		
		return forward;
	}
	
}

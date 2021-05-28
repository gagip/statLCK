package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();

		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO board = boardDAO.getBoard(num);
		
		request.setAttribute("board", board);
		
		forward.setRedirect(false);
		forward.setNextPath("board_detail.bo");
		
		
		return forward;
	}

}

package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		boardList = boardDAO.getBoardList();
		
		request.setAttribute("boardList", boardList);
		
		forward.setRedirect(false);
		forward.setNextPath("board_list.bo");
		
		return forward;
	}
	
}

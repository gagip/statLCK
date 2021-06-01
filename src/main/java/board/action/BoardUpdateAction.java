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
		
		request.setCharacterEncoding("UTF-8");
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String cate = request.getParameter("cate");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO();
		
		board.setBoardNum(boardNum);
		board.setCate(cate);
		board.setTitle(title);
		board.setContent(content);
		boolean result = boardDAO.updateBoard(board);
		
		if (result) {
			forward.setRedirect(true);
			forward.setNextPath("boardDetailAction.bo?boardNum="+boardNum);
		}
		
		
		return forward;
	}
	
}

package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int memberNum = Integer.parseInt(request.getParameter("member_num"));
		int cate = Integer.parseInt(request.getParameter("cate"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO();
		
		board.setCate(cate);
		board.setTitle(title);
		board.setContent(content);
		
		boardDAO.insertBoard(board, memberNum);
		
		forward.setRedirect(true);
		forward.setNextPath("boardListAction.bo");
		
		
		return forward;
	}

}
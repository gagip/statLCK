package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;
import board.model.BoardDTO;
import member.PointManager;
import member.model.MemberDAO;
import member.model.MemberDTO;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("UTF-8");
		int memberNum = Integer.parseInt(request.getParameter("memberNum"));
		String cate = request.getParameter("cate");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO board = new BoardDTO();
		
		board.setBoardNum(boardDAO.getSeq());
		board.setCate(cate);
		board.setTitle(title);
		board.setContent(content);
		boolean result = boardDAO.insertBoard(board, memberNum);
		
		
		if (result) {
			PointManager pm = PointManager.getInstance();
			pm.addPoint(memberNum, PointManager.BOARD_WRITE_POINT);
			
			forward.setRedirect(true);
			forward.setNextPath("boardDetailAction.bo?boardNum="+board.getBoardNum());
		}
		
		
		return forward;
	}

}

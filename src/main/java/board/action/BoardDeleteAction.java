package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int boardNum = Integer.parseInt(request.getParameter("boardNum")); 
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		boolean result = boardDAO.deleteBoard(boardNum);
		
		if (result) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제되었습니다.');");
			out.println("location.href='boardListAction.bo'");
			out.println("</script>");
			out.flush();
			
		}
		
		
		return forward;
	}

}

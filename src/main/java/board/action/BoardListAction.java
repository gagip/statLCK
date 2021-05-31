package board.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import board.model.BoardDAO;
import board.model.BoardDTO;

public class BoardListAction implements Action{
	private static final int COUNT_PER_PAGE = 10;		// 한 페이지에 보여줄 게시글 수
	private static final int SHOW_PAGENUM = 5;			// 보여줄 페이지 넘버 수
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		
		// Request Parameter 가져오기
		int spage = 1;
		String page = request.getParameter("page");
		if (page != null)
			spage = Integer.parseInt(page);
		
		String opt = request.getParameter("opt");
		String condition = request.getParameter("condition");
		
		// 검색조건과 검색내용을 Map에 담는다
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		listOpt.put("start", spage*COUNT_PER_PAGE-(COUNT_PER_PAGE-1));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		// DB에서 가져오기
		boardList = boardDAO.getBoardList(listOpt);
		int listLen = boardDAO.getBoardListLength(listOpt);
		
		// 페이징 계산
		int maxPage = (int) (listLen/COUNT_PER_PAGE)+1;
		int startPage = (int) (((spage-1)/SHOW_PAGENUM)*SHOW_PAGENUM)+1;
		int endPage = startPage + (SHOW_PAGENUM-1);
		if (endPage > maxPage) endPage = maxPage;
		
		request.setAttribute("spage", spage);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("boardList", boardList);
		
		forward.setRedirect(false);
		forward.setNextPath("board_list.bo");
		
		return forward;
	}
	
}

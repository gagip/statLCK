package board.action;

import javax.servlet.ServletException;

import base.ControllerBase;

public class BoardController extends ControllerBase<BoardViewAction>{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		loadProperties("board/properties/BoardCommend", "board.action.BoardViewAction");
	}

}

package reply.action;

import javax.servlet.ServletException;

import base.ControllerBase;

public class ReplyController extends ControllerBase<ReplyViewAction>{

	@Override
	public void init() throws ServletException {
		loadProperties("reply/properties/ReplyCommend", "reply.action.ReplyViewAction");
	}

}

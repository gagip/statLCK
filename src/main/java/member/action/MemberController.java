package member.action;

import javax.servlet.ServletException;

import base.ControllerBase;

public class MemberController extends ControllerBase<MemberViewAction>{
	private static final long serialVersionUID = 1L;

	
	@Override
	public void init() throws ServletException {
		loadProperties("member/properties/MemberCommend", "member.action.MemberViewAction");
	}
	
}

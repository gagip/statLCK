package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberProfileAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String memberId = request.getParameter("memberId");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO member = memberDAO.getMember(memberId);
		
		request.setAttribute("member", member);
		
		forward.setRedirect(false);
		forward.setNextPath("profile.me");
		
		return forward;
	}

}

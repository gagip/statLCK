package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Action;
import base.ActionForward;
import member.LoginState;
import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberSigninAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		LoginState check = dao.login(id, pw);
		
		
		switch (check) {
		case SUCCESS:
			MemberDTO member = dao.getMember(id);
			session.setAttribute("sessionId", member.getId());
			session.setAttribute("sessionMemberNum", member.getMemberNum());
			
			forward.setRedirect(true);
			forward.setNextPath("index.me");
			break;
		case PW_MISMATCH:
			request.setAttribute("fail", "0");
			
			forward.setRedirect(false);
			forward.setNextPath("signin.me");
			break;
		case NON_EXIST_ID:
			request.setAttribute("fail", "-1");
			
			forward.setRedirect(false);
			forward.setNextPath("signin.me");
			break;

		default:
			break;
		}
		
		
		return forward;
	}

}

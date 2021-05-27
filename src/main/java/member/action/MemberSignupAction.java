package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Action;
import base.ActionForward;
import member.model.MemberDAO;
import member.model.MemberDTO;

public class MemberSignupAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setAddress(request.getParameter("address"));
		member.setTel(request.getParameter("p_image"));
		
		// 회원가입
		dao.addMember(member);
		
		// 가입 성공
		forward.setRedirect(true);
		forward.setNextPath("index.me");
		
		request.getSession().setAttribute("msg", "1");
		
		return forward;
	}

}

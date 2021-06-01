package member;

import member.model.MemberDAO;
import member.model.MemberDTO;

public class PointManager {
	public static PointManager instance = null;
	
	public static final int BOARD_WRITE_POINT = 15;
	public static final int REPLY_WRITE_POINT = 5;
	
	private PointManager() {
		
	}
	
	public static PointManager getInstance() {
		if (instance == null)
			instance = new PointManager();
		return instance;
	}
	
	
	public void addPoint(int memberNum, int point) {
		if (point < 0) return;
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO member = memberDAO.getMember(memberNum);
		
		int memberPoint = member.getPoint();
		int totalPoint = memberPoint + point;
		
		memberDAO.setPoint(memberNum, totalPoint);
	}
	
	
	public void addPoint(String id, int point) {
		if (point < 0) return;
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberDTO member = memberDAO.getMember(id);
		
		int memberNum = member.getMemberNum();
		int memberPoint = member.getPoint();
		int totalPoint = memberPoint + point;
		
		memberDAO.setPoint(memberNum, totalPoint);
	}
}

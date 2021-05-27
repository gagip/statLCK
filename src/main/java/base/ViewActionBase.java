package base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewActionBase implements Action {
	protected String form;
	protected String path;
	
	
	public void setCommand(String command) {
		int idx = command.indexOf(".");
		path = command.substring(0, idx)+".jsp";
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		if (path.equals("index.jsp"))
			forward.setNextPath(path);
		else 
			forward.setNextPath(form+path);
		
		return forward;
	}
}

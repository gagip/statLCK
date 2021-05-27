package base;

public class ActionForward {
	// sendRedirect와 forward 중 어떤 것을 이용할지 결정하는 변수
	private boolean isRedirect = false;
	// 이동할 페이지 경로값을 갖고 있는 변수
	private String nextPath = null;
	
	
	public boolean isRedirect() {
		return isRedirect;
	}

	
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	

	public String getNextPath() {
		return nextPath;
	}


	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}
}

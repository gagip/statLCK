package base;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.MemberViewAction;

/**
 * 페이지 및 액션 클래스를 호출하여 결과 페이지를 반환하는 컨트롤러(서블렛) 클래스 
 * @author gagip
 *
 * @param <T> 화면 전환을 담당하는 ViewAction 클래스 
 */
public abstract class ControllerBase<T extends ViewActionBase> extends HttpServlet{
	protected HashMap<String, Action> commandMap;
	
	/**
	 * loadProperties(String propertiesFilePath, String viewActionClassPath) 메소드를 사용하여 프로퍼티 로드
	 */
	@Override
	public abstract void init() throws ServletException;
	
	@Override
	protected void doGet(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		doProcess(reqeust, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		doProcess(reqeust, response);
	}
	
	
	
	/**
	 * 프로퍼티 파일 로드
	 * @param propertiesFilePath 프로퍼티 파일 경로 ex)<i>member/properties/MemberCommend</i>
	 * @param viewActionClassPath 화면전환 클래스 경로 ex)<i>member.action.MemberViewAction</i>
	 */
	protected void loadProperties(String propertiesFilePath, String viewActionClassPath) {
		commandMap = new HashMap<String, Action>();
		
		ResourceBundle rb = ResourceBundle.getBundle(propertiesFilePath);
		Enumeration<String> actionEnum = rb.getKeys();
		
		while (actionEnum.hasMoreElements()) {
			String command = actionEnum.nextElement();
			String className = rb.getString(command);
			
			
			try {
				Class actionClass = Class.forName(className);					// 클래스 생성
				Action actionInstance = (Action) actionClass.newInstance();		// 클래스 객체 생성
				
				if (className.equals(viewActionClassPath)) {
					T viewAction = (T) actionInstance;
					viewAction.setCommand(command);
				}
				
				commandMap.put(command, actionInstance);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	
	public void doProcess(HttpServletRequest reqeust, HttpServletResponse response) throws ServletException, IOException {
		// 넘어온 커맨드 추출

		String requestURI = reqeust.getRequestURI();
		int cmdIdx = requestURI.lastIndexOf("/")+1;
		String command = requestURI.substring(cmdIdx);
		
		ActionForward forward = null;
		Action action = null;
		
		
		try {
			action = commandMap.get(command);
			
			if (action == null) {
				System.out.println("명령어: "+command+"는 잘못된 명령입니다");
				return;
			}
			
			forward = action.execute(reqeust, response);
			
			// 화면 이동
			// sendRedirect: 새로운 페이지에서 request와 response 객체 새롭게 생성
			// forward: 현재 실행 중인 페이지와 forward에 의해 호출될 페이지는 request와 response 객체 공유
			if (forward != null) {
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getNextPath());
				} else {
					RequestDispatcher dispatcher = 
							reqeust.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(reqeust, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}

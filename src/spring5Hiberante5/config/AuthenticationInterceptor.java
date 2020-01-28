package spring5Hiberante5.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthenticationInterceptor implements HandlerInterceptor {

	//private static final long maxInActiveTime=5*10000;
	
	@Autowired
	HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		session=request.getSession(false);		
		String path=request.getRequestURI().substring(request.getContextPath().length());						
			
		long startTime=System.currentTimeMillis();
		request.setAttribute("executionTime", startTime);
		
		String xHeader = request.getHeader("X-Auth-Token");
		System.out.println("xHeader : "+xHeader);
		
		if ((path.equals("/") || path.equalsIgnoreCase("/login"))) {
			return true;		
		}else if (session==null || session.getAttribute("userName")==null) {
			response.sendRedirect(request.getContextPath());
			return false;
		}
		return true;
		
//		System.out.println("Current time : "+System.currentTimeMillis());
//		System.out.println("Last access : "+session.getLastAccessedTime());	
//		System.out.println("Time diff : "+(System.currentTimeMillis()-session.getLastAccessedTime())/1000);
//		System.out.println("max inactive time : "+session.getMaxInactiveInterval());		
//		if (((System.currentTimeMillis()-session.getLastAccessedTime())/1000) >= session.getMaxInactiveInterval()) {
//			//System.out.println("max : ");	
//			request.setAttribute("maxIdealTime", "Max Ideal Time exceed");
//		}
//		System.out.println("request.getMethod().equals(\"POST\")"+ request.getMethod().equals("POST"));
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model) throws Exception{
				
//			long startTime=(long) request.getAttribute("executionTime");
//			System.out.println("Execution time for handle the request was : "+(System.currentTimeMillis() - startTime));	
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception{	
		if (ex!=null) {
			ex.printStackTrace();
		}
		//System.out.println("Afetr completion"+request);
	}
}

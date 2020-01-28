package spring5Hiberante5.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelayFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		Integer seconds = 1;
		try {
			System.out.println("Inside filter");
			//Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			throw new ServletException("Interrupted!");
		}
//		HttpServletResponse response = (HttpServletResponse) resp;
//		response.setHeader("Cache-Control", "no-cache, must-revalidate");
//		System.out.println(response.getHeader("Cache-Control"));
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		System.out.println("inside destroy filter");
	}
}
package spring5Hiberante5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring5Hiberante5.bean.Login;
import spring5Hiberante5.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;

	@Autowired
	private HttpServletRequest request;

//	@ExceptionHandler(LoginFailedException.class)
//	public String redirectToLogin() {
//		System.out.println("redirectToLogin");
//		return "redirect:/";
//	}
	
	@RequestMapping(path = "/login", method = {RequestMethod.POST})
	public ModelAndView login(Login login) {

		//System.out.println("login");
		Boolean valid = service.validUser(login, request);

		if (valid) {
			return new ModelAndView("dashboard");
		}

		return new ModelAndView("error");
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logOut() {
		HttpSession session = request.getSession(false);
		session.invalidate();

		return new ModelAndView("index");

	}
	
	@RequestMapping(value = "/checkValidUser", method = RequestMethod.POST)
	public boolean validUser() {
		
		if (request.getSession(false).getAttribute("userName")!=null) {
			return true;
		}
		return false;
	}
}

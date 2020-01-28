package spring5Hiberante5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(path = { "/" }, method = RequestMethod.GET)
	public ModelAndView index() {
		//System.out.println("index");
		return new ModelAndView("index");
	}

	
}
package spring5Hiberante5.service;

import javax.servlet.http.HttpServletRequest;

import spring5Hiberante5.bean.Login;

public interface LoginService {

	public Boolean validUser(Login login, HttpServletRequest request);
}

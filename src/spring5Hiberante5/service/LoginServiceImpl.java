package spring5Hiberante5.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring5Hiberante5.bean.Login;
import spring5Hiberante5.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao dao;

	@Override
	@Transactional
	public Boolean validUser(Login login, HttpServletRequest request) {

		ArrayList<Login> loginList = dao.userList(login);

		for (Login entry : loginList) {
			if (login.getEmail() != null && login.getPassword() != null) {
				if (login.getEmail().equals(entry.getEmail()) && login.getPassword().equals(entry.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute("userName", entry.getUserName());
					session.setAttribute("email", entry.getEmail());
					session.setMaxInactiveInterval(300);
					return true;
				} else {
					return false;
				}
			}
		}

		return false;
	}
}

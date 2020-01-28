package spring5Hiberante5.dao;

import java.util.ArrayList;

import spring5Hiberante5.bean.Login;

public interface LoginDao {

	public ArrayList<Login> userList(Login login);
}

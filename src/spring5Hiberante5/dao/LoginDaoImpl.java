package spring5Hiberante5.dao;

import java.util.ArrayList;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring5Hiberante5.bean.Login;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Login> userList(Login login) {

		Session session=sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Login> cq=cb.createQuery(Login.class);		
		Root<Login> root = cq.from(Login.class);
		cq.select(root).where(root.get("email").in(login.getEmail()));
		Query query = session.createQuery(cq);
		return (ArrayList<Login>) query.getResultList();

	}

}

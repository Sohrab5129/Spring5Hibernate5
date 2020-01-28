package spring5Hiberante5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring5Hiberante5.bean.Brand;

@Repository
public class ModifyShoppingDaoImpl implements ModifyShoppingDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Brand getBrandById(int brandId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Brand brand = currentSession.get(Brand.class, brandId);
		return brand;
	}

	@Override
	public void updateBrandCategory(Brand brand) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(brand);
	}

}

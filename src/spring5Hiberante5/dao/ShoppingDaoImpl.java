package spring5Hiberante5.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring5Hiberante5.bean.Brand;
import spring5Hiberante5.bean.Category;
import spring5Hiberante5.bean.OperatingSystem;
import spring5Hiberante5.bean.Product;

@Repository
@SuppressWarnings("unchecked")
public class ShoppingDaoImpl implements ShoppingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Brand> getListBrand() {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Brand> cq = cb.createQuery(Brand.class);
		Root<Brand> root = cq.from(Brand.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public List<Brand> getListBrandById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Brand> cq = cb.createQuery(Brand.class);
		Root<Brand> root = cq.from(Brand.class);
		cq.select(root).where(root.get("id").in(id));
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void addProduct(Product prod) {
		Session currentSession = sessionFactory.getCurrentSession();		
		currentSession.save("spring5Hiberante5.bean.Product",prod);
	}

	@Override
	public void addOS(OperatingSystem os) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(os);
		
	}

	@Override
	public void addCategory(Category category) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(category);
		
	}

	@Override
	public List<Category> getCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Category> cq = cb.createQuery(Category.class);
		Root<Category> root = cq.from(Category.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public List<OperatingSystem> getOSTypes(OperatingSystem os) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<OperatingSystem> cq = cb.createQuery(OperatingSystem.class);
		Root<OperatingSystem> root = cq.from(OperatingSystem.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void addBrand(Brand brand) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(brand);
	}

}

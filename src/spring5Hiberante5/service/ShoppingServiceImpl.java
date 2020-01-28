package spring5Hiberante5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring5Hiberante5.bean.Brand;
import spring5Hiberante5.bean.Category;
import spring5Hiberante5.bean.OperatingSystem;
import spring5Hiberante5.bean.Product;
import spring5Hiberante5.dao.ShoppingDao;

@Service
@Transactional
public class ShoppingServiceImpl implements ShoppingService {

	@Autowired
	private ShoppingDao shopDao;
	
	@Override
	public List<Brand> getListBrand() {
		
		return shopDao.getListBrand();
	}

	@Override
	public List<Brand> getListBrandById(int i) {
		return shopDao.getListBrandById(i);
	}

	@Override
	public void addProduct(Product prod) {
		shopDao.addProduct(prod);
		
	}

	@Override
	public void addOS(OperatingSystem os) {
		shopDao.addOS(os);
		
	}

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		shopDao.addCategory(category);
	}

	@Override
	public List<Category> getCategory(Category category) {
		return shopDao.getCategory(category);
	}

	@Override
	public List<OperatingSystem> getOSTypes(OperatingSystem os) {
		return shopDao.getOSTypes(os);
	}

	@Override
	public void addBrand(Brand brand) {

		shopDao.addBrand(brand);
	}

}

package spring5Hiberante5.service;

import java.util.List;

import spring5Hiberante5.bean.Brand;
import spring5Hiberante5.bean.Category;
import spring5Hiberante5.bean.OperatingSystem;
import spring5Hiberante5.bean.Product;

public interface ShoppingService {

	public List<Brand> getListBrand();

	public List<Brand> getListBrandById(int i);

	public void addProduct(Product product);

	public void addOS(OperatingSystem os);

	public void addCategory(Category category);

	public List<Category> getCategory(Category category);

	public List<OperatingSystem> getOSTypes(OperatingSystem os);

	public void addBrand(Brand brand);
	
	
}

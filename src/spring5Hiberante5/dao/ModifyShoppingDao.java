package spring5Hiberante5.dao;

import spring5Hiberante5.bean.Brand;

public interface ModifyShoppingDao {

	Brand getBrandById(int brandId);

	public void updateBrandCategory(Brand brand);

}

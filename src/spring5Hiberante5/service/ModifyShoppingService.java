package spring5Hiberante5.service;

import spring5Hiberante5.bean.Brand;

public interface ModifyShoppingService {

	Brand getBrandById(int brandId);

	void updateBrandCategory(Brand brand);

}

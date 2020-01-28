package spring5Hiberante5.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5Hiberante5.bean.Brand;
import spring5Hiberante5.dao.ModifyShoppingDao;

@Service
@Transactional
public class ModifyShoppingServiceImpl implements ModifyShoppingService {

	@Autowired
	private ModifyShoppingDao modifyShoppingDao;
	
	@Override
	public Brand getBrandById(int brandId) {
		return modifyShoppingDao.getBrandById(brandId);
	}

	@Override
	public void updateBrandCategory(Brand brand) {
		modifyShoppingDao.updateBrandCategory(brand);
	}

}

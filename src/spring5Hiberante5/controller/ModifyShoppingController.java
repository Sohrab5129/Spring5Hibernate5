package spring5Hiberante5.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import spring5Hiberante5.bean.Brand;
import spring5Hiberante5.bean.Category;
import spring5Hiberante5.service.ModifyShoppingService;
import spring5Hiberante5.service.ShoppingService;

@Controller
@SessionScope
@RequestMapping("/modify")
public class ModifyShoppingController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ModifyShoppingService modifyShoppingservice;

	@Autowired
	private ShoppingService shopService;

	@RequestMapping(value = "/updateLinkedBrandCategory", method = RequestMethod.GET)
	public String updateLinkedBrandCategory(@RequestParam("brandId") int brandId, ModelMap model, Category category) {

		Brand brand = modifyShoppingservice.getBrandById(brandId);

		List<Category> categories = shopService.getCategory(category);
		Set<Category> setcat = new HashSet<Category>(categories);

		Set<Category> availableCategory=new HashSet<Category>();
		for (Category cat : setcat) {
			availableCategory.add(cat);
		}
		
		for (Category linkedcategory : brand.getCategory()) {
			availableCategory.remove(linkedcategory);
		}

		model.addAttribute("availableCategory", availableCategory);
		model.addAttribute("linkedCategory", brand.getCategory());
		model.addAttribute("brand", brand);
		return "updateBrand";

	}

	@RequestMapping(value = "/updateBrand", method = RequestMethod.POST)
	public String updateBrand() {
		
		String brandId=request.getParameter("brandId");
		String[] cat=request.getParameterValues("catId[]");
		String brandName=request.getParameter("brandName");
	//	String brandId=request.getParameter("brandId");
		
		List<Category> listCategories=shopService.getCategory(new Category());
		
		Brand brand=new Brand();
		Category category=null;
		Set<Category> categories=null;
		categories=new HashSet<Category>();
		
		
		brand.setId(Integer.parseInt(brandId));
		brand.setName(brandName);
		
		System.out.println(brandId);
		for(String id:cat) {
			if (Integer.parseInt(id) == -1) {
				continue;
			}
			for (Category category2 : listCategories) {
				if (category2.getId()==Integer.parseInt(id)) {
					category=new Category();
					category.setName(category2.getName());
					category.setId(Integer.parseInt(id));
					categories.add(category);
				}
			}			
		}
		brand.setCategory(categories);
		modifyShoppingservice.updateBrandCategory(brand);
		
		return "redirect:/shop/getCategory";
	}
}

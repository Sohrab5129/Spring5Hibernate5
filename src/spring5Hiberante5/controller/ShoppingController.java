package spring5Hiberante5.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import spring5Hiberante5.bean.Brand;
import spring5Hiberante5.bean.Category;
import spring5Hiberante5.bean.Employee;
import spring5Hiberante5.bean.OperatingSystem;
import spring5Hiberante5.bean.Product;
import spring5Hiberante5.service.ShoppingService;

@Controller
@RequestMapping("/shop")
public class ShoppingController {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private ShoppingService shopService;
	
	@GetMapping("/myShop")
	public ModelAndView myShop() {
		
		if (request.getSession(false).getAttribute("userName")!=null) {
			
			System.out.println("inside shop"+request.getSession(false).isNew()); 
			return new ModelAndView("shoppingCart");
		}
		
		return new ModelAndView("index");
		
	}
	
	@RequestMapping(value = "/listBrand" , method = RequestMethod.POST)
	public @ResponseBody String getListBrand(Model model) {

		Gson gson = new Gson();
		List<Brand> brand = shopService.getListBrand();
		HashMap<Integer, String> hashMapBrand = new HashMap<Integer, String>();
		for (Brand b : brand) {
			hashMapBrand.put(b.getId(), b.getName());

		}
		model.addAttribute("Brand", hashMapBrand);
		String json = gson.toJson(model);
		return json;
	}
	
	@RequestMapping(value = "/listCategoryByBrandId" , method = RequestMethod.POST)
	public @ResponseBody String getCategoryByBrandId(Model model) {
		
		int id=Integer.parseInt(request.getParameter("id"));
		Gson gson = new Gson();
		List<Brand> brandListById=shopService.getListBrandById(id);
		HashMap<Integer, String> hashMapCategory = new HashMap<Integer, String>();		
		for(Brand b: brandListById) {
			Set<Category> categories=b.getCategory();
			categories.forEach(category->{
				hashMapCategory.put(category.getId(), category.getName());
			});
		}
		model.addAttribute("listCategoryByBrandId", hashMapCategory);
		String json=gson.toJson(model);
		return json;
		
	}
	
	@RequestMapping(value = "/listOSyByCategoryId", method = RequestMethod.POST)
	public @ResponseBody String getOsTypeByCategoryId(Model model) {
		
		int brandId=Integer.parseInt(request.getParameter("brandId"));
		int category_id=Integer.parseInt(request.getParameter("category_id"));
		
		System.out.println("brand"+brandId);
		Gson gson = new Gson();
		List<Brand> brandListById=shopService.getListBrandById(brandId);
		HashMap<Integer, String> hashMapOS = new HashMap<Integer, String>();		
		for(Brand b: brandListById) {
			Set<Category> categories=b.getCategory();	
			categories.forEach(category->{	
				if (category.getId()==category_id) {
					
					Set<OperatingSystem> os=category.getOs();
					os.forEach(oslist->{		
						hashMapOS.put(oslist.getId(), oslist.getName());
					});
				}
			});
		}
		model.addAttribute("listOSByCategoryId", hashMapOS);
		String json=gson.toJson(model);
		return json;
	}
	
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public @ResponseBody String addProduct() {
	
		int brandId=Integer.parseInt(request.getParameter("brandId"));
		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		int osId=Integer.parseInt(request.getParameter("osId"));		
		long quantity=Long.valueOf(request.getParameter("total_quantity"));	
		String productName=request.getParameter("product_name");
		String productDescription=request.getParameter("product_description");
		
		Product  product=new Product();
		product.setName(productName);
		product.setQuantity(quantity);
		product.setDescription(productDescription);
		product.setReceivedDate(new Date(System.currentTimeMillis()));
		
		Category category=new Category();
		category.setId(categoryId);
		
		Brand brand=new Brand();
		brand.setId(brandId);
		
		OperatingSystem os=new OperatingSystem();
		os.setId(osId);		
		
		product.setBrand(brand);
		product.setCategory(category);
		product.setOs(os);
		Gson gson = new Gson();
		try {
			shopService.addProduct(product);
		} catch (Exception e) {
			return gson.toJson("fail");
		}	
		return gson.toJson("success");
	}
	
	@RequestMapping(value = "/addOS")
	public ModelAndView addOS(Category category, OperatingSystem os) {
		
	//	List<Category> categories=shopService.getCategory(category);
		
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("addOS", "addOS");

		return new ModelAndView("addOS",hashMap);
	}
	
	@RequestMapping(value = "/addOSType", method = RequestMethod.POST)
	public ModelAndView addOSType(Category category, OperatingSystem os) {
		
		String[] osNames=request.getParameterValues("osName[]");
	//	int categoryId=Integer.parseInt(request.getParameter("categoryId"));
		
//		Category category2=new Category();
//		category2.setId(categoryId);
		
//		Set<Category> cat=new HashSet<Category>();
//		cat.add(category2);
		
		OperatingSystem operatingSystem=null;
	//	Set<OperatingSystem> set=new HashSet<OperatingSystem>();
		
		for (String osName : osNames) {
			if (!osName.trim().isEmpty()) {
				
				operatingSystem=new OperatingSystem();
				operatingSystem.setName(osName.trim());
				shopService.addOS(operatingSystem);
			}
			
		}
			
		//category2.setOs(set);
		
		//shopService.addCategory(category2);
		
		
		
	//	List<Category> categories=shopService.getCategory(category);
		

		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		
		hashMap.put("osAdded", "Successfully added new OS");
		hashMap.put("flag", "success");
		hashMap.put("addOS", "addOS");
		
		return new ModelAndView("addOS",hashMap);
	}
	
	@RequestMapping(value = "/getOS", method = RequestMethod.GET)
	public ModelAndView getOS(OperatingSystem os) {
		
	//	List<Category> categories=shopService.getCategory(category);
		
		List<OperatingSystem> list=shopService.getOSTypes(os);
		
		Set<OperatingSystem> setOS=new HashSet<OperatingSystem>(list);
		System.out.println(setOS);
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("listOS", setOS);

		return new ModelAndView("addCategory",hashMap);
	}
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(Category category, OperatingSystem os) {
		
	//	List<Category> categories=shopService.getCategory(category);
		
		String[] osId=request.getParameterValues("osId[]");
		String categoryName=request.getParameter("categoryName");
		
		Category cat=new Category();
		cat.setName(categoryName);
		
		OperatingSystem system=null;
		Set<OperatingSystem> setSystem=new HashSet<OperatingSystem>();
		List<OperatingSystem> list=shopService.getOSTypes(os);	
		
		for (String id : osId) {
					
			for (OperatingSystem operatingSystem : list) {
				if (operatingSystem.getId()==Integer.parseInt(id)) {
					system=new OperatingSystem();
					system.setId(Integer.parseInt(id));
					system.setName(operatingSystem.getName());
					break;
				}
			}
			setSystem.add(system);
		}
		
		cat.setOs(setSystem);
		shopService.addCategory(cat);	
		
		
		Set<OperatingSystem> setOS=new HashSet<OperatingSystem>(list);
		
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("categoryAdded", "Category added successfully");
		hashMap.put("listOS", setOS);
		hashMap.put("flag", "success");
		
		return new ModelAndView("addCategory",hashMap);
	}
	
	@RequestMapping(value = "/getCategory", method = RequestMethod.GET)
	public ModelAndView getCategory(Category category) {
		
		List<Category> categories=shopService.getCategory(category);
		List<Brand> listBrand=shopService.getListBrand();
		
		Set<Category> setcat=new HashSet<Category>(categories);
		
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		hashMap.put("listcategory", setcat);
		hashMap.put("listBrand", listBrand);
		return new ModelAndView("addBrand",hashMap);
	}
	
	@RequestMapping(value = "/addBrand", method = RequestMethod.POST)
	public ModelAndView addBrand(Category category) {
		
		List<Category> categories=shopService.getCategory(category);
		Set<Category> setcat=new HashSet<Category>(categories);
		
		HashMap<String, Object> hashMap=new HashMap<String, Object>();
		List<Brand> listBrand=shopService.getListBrand();
		
		
		String[] catId=request.getParameterValues("catId[]");
		String brandName=request.getParameter("brandName");
		boolean existBrandName=false;
		
		for (Brand b : listBrand) {
			if (brandName!=null && b.getName().equalsIgnoreCase(brandName.trim())) {
				existBrandName=true;
			}
		}
		
		if (!existBrandName) {
			
			System.out.println(catId+brandName);
			
			Brand brand=new Brand();
			brand.setName(brandName);
			
			Category category2=null;
			Set<Category> setcategory=new HashSet<Category>();
			
			for (String id : catId) {
				category2=new Category();
				category2.setId(Integer.parseInt(id));
				for (Category category3 : categories) {
					if (category3.getId()==Integer.parseInt(id)) {
						category2.setName(category3.getName());
						break;
					}
				}
				
				setcategory.add(category2);
			}
			
			brand.setCategory(setcategory);		
			shopService.addBrand(brand);
			hashMap.put("brandAdded", "Brand added successfully");
		}else {
			hashMap.put("brandAdded", "Brand already present, add new Brand");
		}
			
				
		listBrand=shopService.getListBrand();

		hashMap.put("listcategory", setcat);
		hashMap.put("listBrand", listBrand);
		hashMap.put("flag", "success");
		
		return new ModelAndView("addBrand",hashMap);
	}
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	
	 @RequestMapping("/showSpringValidatedForm")
	public String showSpringValidatedForm(Model theModel) {

        theModel.addAttribute("customer", new Employee());

        return "customer-form1";
	}
	 
	@RequestMapping( value = "/processForm",method = RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("customer") Employee employee, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "customer-form1";
		} else {
			return "customer-confirmation";
		}
	}
}

package com.aj.james.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aj.james.dao.CategoryDAO;
import com.aj.james.dao.ProductDAO;
import com.aj.james.dao.UsersDetailDao;
import com.aj.james.model.Product;





@Controller
public class PageController {
	
		@Autowired
		UsersDetailDao usersDetailDAO;
		
		@Autowired
		private CategoryDAO categoryDAO;
		
		@Autowired
		private ProductDAO productDAO;
		
		@RequestMapping("/403")
		public String getaccessPage()
		{
			return "accessdeniedpage";
		}
		
	
	@RequestMapping("/")
	public ModelAndView getPage(@ModelAttribute("selectedProduct") final Product selectedProduct){
		
	ModelAndView model=new ModelAndView("/index");
		
		model.addObject("categoryList", categoryDAO.list());
		model.addObject("productList", productDAO.list());
		
		
		System.out.println("inside / mapping");

		if(selectedProduct!=null){
			model.addObject("selectedProduct",selectedProduct);
		}
		else
			System.out.println("The object is null");
		
		return model;
	}
	
	@RequestMapping("/index")
	public String getIndexPage(){
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String getAboutPage(){
		
		return "about";
	}
	
	
	
	@RequestMapping("/contact")
	public String getContactPage(){
		
		return "contact";
	}
	
	@RequestMapping("/thankYouPage")
	public String getthankYouPage()
	{
		return "thankYou";
	}
	
	

}

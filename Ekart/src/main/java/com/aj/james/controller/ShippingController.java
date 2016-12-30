package com.aj.james.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aj.james.dao.ShippingDAO;
import com.aj.james.model.Shipping;

@Controller
public class ShippingController {
	
	@Autowired
	ShippingDAO shippingDAO;
	
	@RequestMapping("/shippingPage")
	public String shippingModel(Model model){
		Shipping usershipping = new Shipping();
		model.addAttribute("shippingdetail", usershipping);
		return "shippingPage";
	}
	

}

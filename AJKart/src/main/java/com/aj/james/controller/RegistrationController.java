package com.aj.james.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.james.ajkartbackend.dao.UserDAO;
import com.james.ajkartbackend.model.User;

@Controller
public class RegistrationController {

	@Autowired
	UserDAO userDao;

	@RequestMapping("/register")
	public String resgistermodel(Model model) {
		User user = new User();
		model.addAttribute("userdetails", user);
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView RegistrationForm(@ModelAttribute("userdetails") @Valid User user,BindingResult result){
		System.out.println(" inside register ciontroller");
		
		if (result.hasErrors()) {
			
			ModelAndView model = new ModelAndView("registration");
			return model;
		}
		
		List<User> userDetail = userDao.list();
		
		for (int i = 0; i < userDetail.size(); i++) {
			
			ModelAndView model = new ModelAndView("register");
			
			if(user.getUserEmail().equals(userDetail.get(i).getUserEmail())){
				model.addObject("emailError","Email already exists");
				return model;
			}
			
			if(user.getUsername().equals(userDetail.get(i).getUsername())){
				model.addObject("userNameError","UserName already exists");
				return model;
			}
			
			if(user.getUser_mobile_number().equals(userDetail.get(i).getUser_mobile_number())){
				model.addObject("mobileError","Mobie Number Already exists");
				return model;
			}
			
		}
		userDao.save(user);
		ModelAndView modelAndView = new ModelAndView("registrationsuccess");
		return modelAndView;
	}
}

package com.aj.james.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aj.james.dao.UsersDetailDao;
import com.aj.james.model.Users;
import com.aj.james.model.UsersDetail;

@Controller
public class RegistrationController {

	@Autowired
	UsersDetailDao userDao;

	@RequestMapping("/register")
	public String registermodel(Model model) {
		UsersDetail user = new UsersDetail();
		model.addAttribute("userdetails", user);
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView RegistrationForm(@Valid @ModelAttribute("userdetails") UsersDetail usersDetail,BindingResult result){
		System.out.println(" inside register controller");
		System.out.println(usersDetail.getUserId());
		
		if (result.hasErrors()) {
			
			ModelAndView model = new ModelAndView("register");
			return model;
		}
		
	//	List<User> userDetail = userDao.list();
		
//		for (int i = 0; i < userDetail.size(); i++) {
//			
//			ModelAndView model = new ModelAndView("register");
//			
////			if(user.getUserEmail().equals(userDetail.get(i).getUserEmail())){
////				model.addObject("emailError","Email already exists");
////				return model;
////			}
////			
////			if(user.getUsername().equals(userDetail.get(i).getUsername())){
////				model.addObject("userNameError","UserName already exists");
////				return model;
////			}
////			
////			if(user.getUser_mobile_number().equals(userDetail.get(i).getUser_mobile_number())){
////				model.addObject("mobileError","Mobie Number Already exists");
////				return model;
////			}
//			
//		}
		usersDetail.setEnabled(true);
		userDao.addUser(usersDetail);
		ModelAndView modelAndView = new ModelAndView("registrationsuccess");
		return modelAndView;
	}
	
	
	
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		//System.out.println("Inside login mapping");
		//System.out.println(logout+"    "+error);
		
		if (error != null) {
			model.addAttribute("error", "Invalid username and password");
			return "registrationsuccess";// return to login page
		}
		
		else if(logout!=null)
			return "redirect:/";//After successfull logout
	
		return "registrationsuccess";// return to login page
		}
}

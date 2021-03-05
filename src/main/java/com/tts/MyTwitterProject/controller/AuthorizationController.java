package com.tts.MyTwitterProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.MyTwitterProject.model.User;
import com.tts.MyTwitterProject.service.UserService;


@Controller
public class AuthorizationController {

     private UserService userService;

    public AuthorizationController(UserService userService) {
    	this.userService = userService;
    }

     @GetMapping("/signup")
     public String registration(Model model){
        User user = new User();
        model.addAllAttributes("User", user);
        return "registration";
}

     @GetMapping("/signup")
     public String createNewUser(@Valid User user,
		                 BindingResult bindingResult,
		                 Model model) {
	//Object userServices;
	
	User userExists = userServices.findByusername(user.getUsername());
	
	if (userExists != null) {
		bindingResult.rejectValue()"username",
		       "error.user",
		       "Username is already taken");
	}

    if (!bindingResult.hasErrors()) {
	userService.saveNewUser(user);
	model.addAttribute("success",
			"Sign up soccessful!");
	model.addAttribute("user", new User());
	
    }

    return "registration";

    }

    @GetMapping("/login")
    public String login() {
	      return "login";
	
}
}

    

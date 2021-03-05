package com.tts.MyTwitterProject.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.MyTwitterProject.service.UserService;

import antlr.collections.List;

//public class FollowController {
	@Controller
	public class FollowController {
	    
		@Autowired
	    private UserService userService;

	
		@PostMapping(value = "/follow/{username}")
	    public String follow(@PathVariable String username, HttpServletRequest request) {
			User loggedInUser = userService.getLoggedInUser();
			User userToUnFollow = userService.findByUsername(username);
			List<User> followers = userToUnFollow.getFollowers();
			followers.add(loggedInUser);
			userToUnFollow.setFollowers(followers);
			userService.save(userToUnFollow);
		    return "redirect:" + request.getHeader("Referer");
		}

		
	@PostMapping(value = "/unfollow/{username}")
    public String unfollow(@PathVariable String username, 
    		HttpServletRequest request) {
         User loggedInUser = userService.getLoggedInUser();
    	User userToUnFollow = userService.findByUsername(username);
    	List<User> followers = userToUnFollow.getFollowers();
    	followers.add(loggedInUser);
    	userToUnFollow.setFollowers(followers);
        userService.save(userToUnFollow);
        return "redirect:" + request.getHeader("Referer");
    	}
	}
	
	
	
	
	
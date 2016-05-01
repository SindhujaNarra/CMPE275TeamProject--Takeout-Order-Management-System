package com.cmpe275.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public void delete(@RequestParam("id") String id,ModelMap model) {
		 
		System.out.println(id);
	}
	
	@RequestMapping(value="/getprofilehtml", method=RequestMethod.POST)
	public String helloWorld(@RequestParam("id") String id,ModelMap model) {
		 
		System.out.println("wtf");
		return "error";
		
	}
}

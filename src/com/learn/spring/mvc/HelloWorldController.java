package com.learn.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	// need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from HTML form and convert the data to all caps
		String name = request.getParameter("studentName").toUpperCase();
		
		// create message
		String result = "Yo! " + name;
		
		// add message to the model
		model.addAttribute("result", result);
		
		return "helloworld";
		
		
	}
	
	@RequestMapping("/processFormVersionThree")
	// @RequestParam read the request parameter from HTML form and
	public String processFromVersionThree(@RequestParam("studentName") String name, Model model) {
		// convert the data to all caps
		String lname = name.toUpperCase();
		
		// create message
		String result = "Hey My Friend v3! " + lname;
		
		// add message to the model
		model.addAttribute("result", result);
		
		return "helloworld";
		
		
	}

}

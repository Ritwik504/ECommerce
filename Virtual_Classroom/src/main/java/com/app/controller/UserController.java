package com.app.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.User;
import com.app.service.IUserService;

@Controller //controller is the class level annotation To inform the compiler this class is a controller class  
@RequestMapping("/user")  //Request mapping annotations can also use with the controller annotation at the class level  To segregate one type of the request 
public class UserController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;

	public UserController() {
		System.out.println("in ctor of " + getClass());
	}
	
	

	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String pass, Model map,HttpSession session, User user)
	{
		user.setName(email); user.setPass(pass);
		User us = userService.authenticateUser(email, pass);
		session.setAttribute("user", us);
		map.addAttribute("user",us);
		map.addAttribute("allUser",userService.getAllUsers());
		return  "/user/regUsers";
		
		
	}
	@GetMapping("/logout")
	public String logoutUser(HttpSession session,Model map,HttpServletResponse resp,HttpServletRequest req)
	{
		if(!session.isNew())
		{
			User us = (User) session.getAttribute("user");
			map.addAttribute("username",us);
			session.invalidate(); //Invalidates this session and unbinds any Data associated with that object data with 
			// HTTP resp header: refresh : delay in second , url
			// API of HttpServletResponse : public void setHeader()
			System.out.println("ctx path :  "+req.getContextPath());
			resp.setHeader("refresh", "5;url="+req.getContextPath());
			return "/user/logout";
		}
		return "redirect:/user/login";
		
	}
	
	
	@PostMapping("/register")
	public String RegisterUser(@RequestParam String name, @RequestParam String email, @RequestParam String pass, User user) {
		System.out.println("-------------------");
		user.setEmail(email); user.setName(name); user.setPass(pass);
		String mesg = userService.registerUser(user);
		return "/user/login";
		
	}
	
	@GetMapping("/forgot_pass")
	public String forgotPassPage(Model map)
	{
		map.addAttribute("time", LocalDateTime.now());
		System.out.println("in home page method");
		return "/user/resetPass";
	}
	@GetMapping("/register")
	public String ShowRegisterPage(Model map)
	{
		map.addAttribute("time", LocalDateTime.now());
		System.out.println("in home page method");
		return "/user/register";
	}
	@GetMapping("/login")
	public String showLoginPage() {
		return "/user/login";
	}
	@GetMapping("/message")
	public String showMessageForm() {
		return"/user/message";
	}
	@PostMapping("/submit_chat")
	public String submitChat(@RequestParam String message, HttpSession session, Model map, User user) {
		User us = (User)session.getAttribute("user");
		userService.saveChat(message, us);
		map.addAttribute("us", us);
		return "/user/status";
	}
	
}

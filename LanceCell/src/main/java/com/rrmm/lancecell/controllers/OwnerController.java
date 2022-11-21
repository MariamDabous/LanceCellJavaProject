package com.rrmm.lancecell.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrmm.lancecell.models.LoginUser;
import com.rrmm.lancecell.models.Owner;
import com.rrmm.lancecell.services.OwnerService;
@Controller
@RequestMapping("/owners")
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("userId")!=null) {
			return "redirect:/owners/home";
		}
		else {
			model.addAttribute("newLogin", new LoginUser());
			model.addAttribute("newOwner", new Owner());
			return "/owners/index.jsp";
		}
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newOwner")Owner newOwner,BindingResult result, Model model, HttpSession session) {
		Owner owner=ownerService.register(newOwner, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "/owners/index.jsp";
		}
		else {
			session.setAttribute("ownerId", owner.getId());
			session.setAttribute("loggedOwner", owner);
			return "redirect:/owners/home";
		}
	}
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin,BindingResult result, Model model, HttpSession session) {
		Owner owner=ownerService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newOwner", new Owner());
			return "/owners/index.jsp";
		}
		else {
			session.setAttribute("ownerId", owner.getId());
			session.setAttribute("loggedOwner", owner);
			return "redirect:/owners/home";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("ownerId")!=null) {
			session.invalidate();
		}
		return "redirect:/owners";
	}
	@GetMapping("/home")
	public String success(HttpSession session) {
		if(session.getAttribute("ownerId")!=null) {
			return "redirect:/projects";
		}
		else {
			return "redirect:/owners";
		}
	}
}

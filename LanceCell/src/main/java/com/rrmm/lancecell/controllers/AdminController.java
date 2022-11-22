package com.rrmm.lancecell.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rrmm.lancecell.models.Programmer;
import com.rrmm.lancecell.models.User;
import com.rrmm.lancecell.services.ProgrammerService;
import com.rrmm.lancecell.services.UserService;
import com.rrmm.lancecell.validator.UserValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    
private UserValidator userValidator;
@Autowired
ProgrammerService programmerService;
    
    // NEW
    public AdminController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "/admins/registrationPage.jsp";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "/admins/registrationPage.jsp";
        }
        userService.saveUserWithAdminRole(user);
        return "redirect:/admin/login";
    }
    
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "/admins/loginPage.jsp";
    }
    @RequestMapping(value = { "/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("AllRequests" , programmerService.allProgramers() ) ; 
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "/admins/homePage.jsp";
    }
    @RequestMapping("")
    public String redirHome() {
    	return "redirect:/admin/";
    }
    @GetMapping("/Profile/{id}")
	public String ShowProgrammer(Model model, HttpSession session,@PathVariable("id") Long id) {
		Programmer thisProg = programmerService.find(id);
		model.addAttribute("thisProg", thisProg);
		return "programmers/profile.jsp";
	
	}
    @GetMapping("/accept/{id}")
 	public String AcceptProgrammer(Model model, HttpSession session,@PathVariable("id") Long id) {
 		Programmer thisProg = programmerService.find(id);
 		
 		thisProg.setIsApproved(true);
 		programmerService.update(thisProg);
 		

 		return "redirect:/admin/";
 	
 	}
    @GetMapping("/reject/{id}")
 	public String RejectProgrammer(Model model, HttpSession session,@PathVariable("id") Long id) {
 		Programmer thisProg = programmerService.find(id);
 		programmerService.delete(thisProg);

 		return "redirect:/admin/";
 	
 	}
}

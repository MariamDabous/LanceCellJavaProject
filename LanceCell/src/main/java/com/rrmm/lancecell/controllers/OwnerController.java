package com.rrmm.lancecell.controllers;

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

import com.rrmm.lancecell.models.LoginUser;
import com.rrmm.lancecell.models.Owner;
import com.rrmm.lancecell.models.Programmer;
import com.rrmm.lancecell.models.Project;
import com.rrmm.lancecell.services.OwnerService;
import com.rrmm.lancecell.services.ProgrammerService;
import com.rrmm.lancecell.services.ProjectService;
@Controller
@RequestMapping("/owners")
public class OwnerController {
	@Autowired
	OwnerService ownerService;
	@Autowired
	ProgrammerService programmerService;
	@Autowired
	ProjectService projectService;
	
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
			return "redirect:/owners/Dashboard";
		}
		else {
			return "redirect:/owners";
		}
	}

	@GetMapping("/Dashboard")
	public String ProgDash(Model model , HttpSession session) {
		if (session.getAttribute("ownerId") != null) {
	        Long owner_id = (Long) session.getAttribute("ownerId");
	        Owner thisOwner = ownerService.find(owner_id);
	        model.addAttribute("thisOwner", thisOwner);
	        model.addAttribute("AllProjects" , thisOwner.getMyProjects());
	        return "owners/dashboard.jsp";
	    } 
	        else {
	            return "redirect:/";
	        }
	}
	
	@GetMapping("/accept/{projId}/{progId}")
	public String progAccept(HttpSession session,@PathVariable("projId")Long projId, @PathVariable("progId")Long progId, Model model) {
		Project thisProj=projectService.find(projId);
		Programmer thisProg=programmerService.find(progId);
		thisProg.setProject(thisProj);
		thisProj.getRequests().remove(thisProg);
		programmerService.update(thisProg);
		return "redirect:/projects/requests";
	}
	@GetMapping("/reject/{projId}/{progId}")
	public String progReject(HttpSession session,@PathVariable("projId")Long projId, @PathVariable("progId")Long progId, Model model) {
		Project thisProj=projectService.find(projId);
		Programmer thisProg=programmerService.find(progId);
		thisProj.getRequests().remove(thisProg);
		projectService.update(thisProj);
		return "redirect:/projects/requests";
	}


}

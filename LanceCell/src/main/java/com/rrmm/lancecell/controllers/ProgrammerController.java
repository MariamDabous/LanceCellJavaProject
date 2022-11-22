package com.rrmm.lancecell.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrmm.lancecell.models.LoginUser;
import com.rrmm.lancecell.models.Owner;
import com.rrmm.lancecell.models.Programmer;
import com.rrmm.lancecell.models.Project;
import com.rrmm.lancecell.services.LanguageService;
import com.rrmm.lancecell.services.ProgrammerService;
import com.rrmm.lancecell.services.ProjectService;

@Controller
@RequestMapping("/programmers")
public class ProgrammerController {
	@Autowired
	ProgrammerService programmerService;
	@Autowired
    ProjectService ProjectServ;
	@Autowired
    LanguageService LanguageServ;
	
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("programmerId")!=null) {
			return "redirect:/programmers/home";
		}
		else {
			model.addAttribute("newLogin", new LoginUser());
			model.addAttribute("newProgrammer", new Programmer());
			return "/programmers/index.jsp";
		}
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newProgrammer")Programmer newProgrammer,BindingResult result, Model model, HttpSession session) {
		Programmer programmer=programmerService.register(newProgrammer, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "/programmers/index.jsp";
		}
		else {
			session.setAttribute("programmerId", programmer.getId());
			session.setAttribute("loggedProgrammer", programmer);
			if(programmer.getIsApproved() == false) {
				return "/programmers/notApprove.jsp";
			}
			return "redirect:/programmers/home";
		}
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin,BindingResult result, Model model, HttpSession session) {
		Programmer programmer=programmerService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newProgrammer", new Programmer());
			return "/programmers/index.jsp";
		}
		else {
			session.setAttribute("programmerId", programmer.getId());
			session.setAttribute("loggedProgrammer", programmer);
			if(programmer.getIsApproved() == false) {
				return "/programmers/notApprove.jsp";
			}
			return "redirect:/programmers/home";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("programmerId")!=null) {
			session.invalidate();
		}
		return "redirect:/programmers";
	}
	
	@GetMapping("/home")
	public String success(HttpSession session) {
		if(session.getAttribute("programmerId")!=null) {
			return "redirect:/programmers/Dashboard";
		}
		else {
			return "redirect:/programmers";
		}
	}

	@GetMapping("/Dashboard")
	public String ProgDash(Model model , HttpSession session) {
		if (session.getAttribute("programmerId") != null) {
	        Long Programmer_id = (Long) session.getAttribute("programmerId");
	        Programmer thisProg = programmerService.find(Programmer_id);
	        model.addAttribute("thisProg", thisProg);
	        model.addAttribute("AllProjects" , ProjectServ.allProjects());
	        model.addAttribute("thisProgProject" , thisProg.getProject());
	        model.addAttribute("sentRequests", thisProg.getSentRequests());
	        model.addAttribute("AllLanguages" , LanguageServ.allLanguages());
	        return "programmers/dashboard.jsp";
	    }
	        else {
	            return "redirect:/";
	        }
	}
	

	@GetMapping("/Profile/{id}")
	public String ShowProgrammer(Model model, HttpSession session,@PathVariable("id") Long id) {
		Programmer thisProg = programmerService.find(id);
		model.addAttribute("thisProg", thisProg);
		return "programmers/profile.jsp";
	
	}

	 @GetMapping("/show/{id}")
	    public String showBook(Model model , @PathVariable("id") Long id,HttpSession session){
	    	Long prog_id = (Long) session.getAttribute("programmerId");
	    	Programmer Prog = programmerService.find(prog_id);
	    	model.addAttribute("logged", Prog);
	        Project project = ProjectServ.find(id);
	        model.addAttribute("project", project);
	    	return "projects/ViewProject.jsp";
	    }

	@PostMapping("/joinRequest/{id}")
	public String joinTeam(HttpSession session,@PathVariable("id")Long projId , Model model) {
		Long Programmer_id = (Long) session.getAttribute("programmerId");
		Programmer thisProg = programmerService.find(Programmer_id);
		Project thisProject= ProjectServ.find(projId);
		thisProject.getRequests().add(thisProg);
		ProjectServ.update(thisProject);
		return "redirect:/programmers/Dashboard";
	}
	
	@DeleteMapping("/deleteRequest/{id}")
	public String cancelRequest(HttpSession session,@PathVariable("id")Long projId , Model model) {
		Long Programmer_id = (Long) session.getAttribute("programmerId");
		Programmer thisProg = programmerService.find(Programmer_id);
		Project thisProject= ProjectServ.find(projId);
		thisProject.getRequests().remove(thisProg);
		ProjectServ.update(thisProject);
		return "redirect:/programmers/Dashboard";
		
	}


}


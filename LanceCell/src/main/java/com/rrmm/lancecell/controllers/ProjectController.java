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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rrmm.lancecell.models.Owner;
import com.rrmm.lancecell.models.Project;
import com.rrmm.lancecell.services.OwnerService;
import com.rrmm.lancecell.services.ProjectService;

@RequestMapping("/projects")
@Controller
public class ProjectController {
    @Autowired
	private ProjectService projectService;
    
    @Autowired
	private OwnerService ownerService;
    
    //---------------------------------- Add Project ----------------------------//
    
    @GetMapping("/add")
    public String addProject(@ModelAttribute("project") Project project,HttpSession session,Model model) {
		if(session.getAttribute("ownerId")==null) {
			return "redirect:/owners";
		}
        return "/projects/projectform.jsp";
    }
    
    @PostMapping("/add")
    public String create(@Valid @ModelAttribute("project") Project project, BindingResult result,Model model,HttpSession session) {
		Owner Logged = ownerService.find((Long)session.getAttribute("ownerId"));
		model.addAttribute("logged", Logged);
    	if (result.hasErrors()) {
            return "projects/projectform.jsp";
        } else {
        	project.setOwner(Logged);
            projectService.create(project);
            return "redirect:/projects"; //---------Edit Route-------//
        }
    }
    //-------------------------- Show Project -----------------------------------// 
    
    @GetMapping("/show/{id}")
    public String showBook(Model model , @PathVariable("id") Long id,HttpSession session){
    	Long owner_id = (Long) session.getAttribute("ownerId");
    	Owner owner = ownerService.find(owner_id);
    	model.addAttribute("logged", owner);
        Project project = projectService.find(id);
        model.addAttribute("project", project);
    	return "projects/ViewProject.jsp";
    }
    
    
  //-------------------------- Edit Project -----------------------------------//
    
	   @GetMapping("/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
			if(session.getAttribute("ownerId") == null) {
				return "redirect:/logout";
			}
	    	Project project = projectService.find(id);
	        model.addAttribute("project", project);
	        return "EditProject.jsp";
	    }
	   @PutMapping("/edit/{id}")
	    public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("project") Project project, BindingResult result,HttpSession session) {
			Long owner_id = (Long) session.getAttribute("ownerId");
			if(!project.getOwner().getId().equals(owner_id)) {
				return "redirect:/projects"; //---------Edit Route-------//
			}
	    	if (result.hasErrors()) {
	            return "projects/EditProject.jsp";
	        } else {
	        	projectService.update(project);
	            return "redirect:/projects"; //---------Edit Route-------//
	        }
	    }
	   // ------------------------------------ Delete -----------------------------------------//
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id, HttpSession session, Model model) {
			if(session.getAttribute("ownerId") == null) {
				return "redirect:/logout";
			}		
			Project project = projectService.find(id);	
			projectService.delete(project);
			return "redirect:/dashboard";
		}
}
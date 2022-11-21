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
<<<<<<< HEAD
    public String addProject(@ModelAttribute("project") Project project,HttpSession session,Model model) {
		if(session.getAttribute("ownerId")==null) {
			return "redirect:/owners";
		}
        return "/projects/projectform.jsp";
=======
    public String addProject(@ModelAttribute("project") Project newProject,HttpSession session) {
		if(session.getAttribute("owner_id")==null) {
			return "redirect:/logout";
		}
        return "projects/projectform.jsp";
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
    }
    
    @PostMapping("/add")
    public String create(@Valid @ModelAttribute("project") Project project, BindingResult result,Model model,HttpSession session) {
<<<<<<< HEAD
		Owner Logged = ownerService.find((Long)session.getAttribute("ownerId"));
		model.addAttribute("logged", Logged);
    	if (result.hasErrors()) {
            return "projects/projectform.jsp";
=======
		Owner Logged = ownerService.find((Long)session.getAttribute("owner_id"));
		model.addAttribute("logged", Logged);
    	if (result.hasErrors()) {
            return "NewProject.jsp";
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
        } else {
        	project.setOwner(Logged);
            projectService.create(project);
            return "redirect:/projects"; //---------Edit Route-------//
        }
    }
    //-------------------------- Show Project -----------------------------------// 
    
    @GetMapping("/show/{id}")
    public String showBook(Model model , @PathVariable("id") Long id,HttpSession session){
<<<<<<< HEAD
    	Long owner_id = (Long) session.getAttribute("ownerId");
=======
    	Long owner_id = (Long) session.getAttribute("owner_id");
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
    	Owner owner = ownerService.find(owner_id);
    	model.addAttribute("logged", owner);
        Project project = projectService.find(id);
        model.addAttribute("project", project);
    	return "projects/ViewProject.jsp";
    }
    
    
  //-------------------------- Edit Project -----------------------------------//
    
	   @GetMapping("/edit/{id}")
	    public String edit(@PathVariable("id") Long id, Model model,HttpSession session) {
<<<<<<< HEAD
			if(session.getAttribute("ownerId") == null) {
=======
			if(session.getAttribute("owner_id") == null) {
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
				return "redirect:/logout";
			}
	    	Project project = projectService.find(id);
	        model.addAttribute("project", project);
	        return "EditProject.jsp";
	    }
<<<<<<< HEAD
	   @PutMapping("/edit/{id}")
	    public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("project") Project project, BindingResult result,HttpSession session) {
			Long owner_id = (Long) session.getAttribute("ownerId");
=======
	   @PutMapping("	/edit/{id}")
	    public String update(@PathVariable("id") Long id,@Valid @ModelAttribute("project") Project project, BindingResult result,HttpSession session) {
			Long owner_id = (Long) session.getAttribute("owner_id");
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
			if(!project.getOwner().getId().equals(owner_id)) {
				return "redirect:/projects"; //---------Edit Route-------//
			}
	    	if (result.hasErrors()) {
	            return "projects/EditProject.jsp";
	        } else {
	        	projectService.update(project);
<<<<<<< HEAD
	            return "redirect:/projects"; //---------Edit Route-------//
=======
	            return "redirect:/project"; //---------Edit Route-------//
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
	        }
	    }
	   // ------------------------------------ Delete -----------------------------------------//
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id, HttpSession session, Model model) {
<<<<<<< HEAD
			if(session.getAttribute("ownerId") == null) {
=======
			if(session.getAttribute("owner_id") == null) {
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
				return "redirect:/logout";
			}		
			Project project = projectService.find(id);	
			projectService.delete(project);
			return "redirect:/dashboard";
		}
<<<<<<< HEAD
}
=======
}
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342

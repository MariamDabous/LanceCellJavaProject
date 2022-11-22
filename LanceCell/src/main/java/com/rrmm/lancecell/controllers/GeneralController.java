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
public class GeneralController {
	@GetMapping("/")
	public String HomePage() {
		return "Home.jsp";
	}
	@GetMapping("/contactUs")
	public String ContactUs() {
		return "ContactUs.jsp";
	}
	

}

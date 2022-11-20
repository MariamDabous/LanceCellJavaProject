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
import org.springframework.web.bind.annotation.RestController;
import com.rrmm.lancecell.models.LoginUser;
import com.rrmm.lancecell.models.Programmer;
import com.rrmm.lancecell.models.User;
import com.rrmm.lancecell.services.ProgrammerService;
import com.rrmm.lancecell.services.UserService;

@Controller
public class LoginController {
	@Autowired
    private UserService  userServ;
	@Autowired
	private ProgrammerService progServ;
	
//User Login and Regestration ---------------------------------------------------------------------------------------------

@GetMapping("/LoginForUser")
public String indexUser(Model model) {
    model.addAttribute("newLogin", new LoginUser());
    return "users/UserLogin.jsp";
}
@GetMapping("/registerForUser")
public String RegUser(Model model) {
    model.addAttribute("newUser", new User());
    return "users/RegistrationPage.jsp";
	
}

@PostMapping("/registerForUser")
public String registerUser(@Valid @ModelAttribute("newUser") User newUser, 
        BindingResult result, Model model, HttpSession session) {
    userServ.register(newUser, result);
    if(result.hasErrors()) {
//    	to add NewLogin for the second form in our jsp file , so there is no errors show . 
        model.addAttribute("newLogin", new LoginUser()); 
        return "users/UserLogin";
    }
    session.setAttribute("user_id", newUser.getId());
    return "redirect:/UserDash";
}

@PostMapping("/loginForUser")
public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
        BindingResult result, Model model, HttpSession session) {
    User user = userServ.login(newLogin, result);
    if(result.hasErrors()) {
        model.addAttribute("newUser", new User());
        return "users/UserLogin.jsp";
    }
    session.setAttribute("user_id", user.getId());
    return "redirect:/users/dashboard";
}

@GetMapping("/UserDash")
public String UserDashboard(Model model, HttpSession session) {
    if (session.getAttribute("user_id") != null) {
    Long user_id = (Long) session.getAttribute("user_id");
    User thisUser = userServ.get(user_id);
    model.addAttribute("thisUser", thisUser);
    return "users/dashboard.jsp";
}
    else {
        return "redirect:/LoginForUser";
    }
}


//Programmer Login and Regestration --------------------------------------------------------------------------------

@GetMapping("/LoginForProg")
public String index(Model model) {
    model.addAttribute("newLogin", new LoginUser());
    return "programmers/ProgLogin.jsp";
}
@GetMapping("/registerForProg")
public String RegProg(Model model) {
	model.addAttribute("newProg", new Programmer());
    return "programmers/ProgrammerReg.jsp";
	
}

@PostMapping("/registerForProg")
public String register(@Valid @ModelAttribute("newProg") Programmer newProg, 
        BindingResult result, Model model, HttpSession session) {
	progServ.register(newProg, result);
    if(result.hasErrors()) {
//    	to add NewLogin for the second form in our jsp file , so there is no errors show . 
        model.addAttribute("newProg", new Programmer()); 
        return "programmers/ProgrammerReg.jsp";
    }
    session.setAttribute("Prog_id", newProg.getId());
    return "redirect:/programmers/dashboard.jsp";
}

@PostMapping("/loginForProg")
public String login(@Valid @ModelAttribute("newProg") LoginUser newProg, 
        BindingResult result, Model model, HttpSession session) {
    Programmer Prog = progServ.login(newProg, result);
    if(result.hasErrors()) {
        model.addAttribute("newUser", new Programmer());
        return "programmers/ProgLogin.jsp";
    }
    session.setAttribute("Prog_id", Prog.getId());
    return "redirect:/ProgrammerDashboard";
}
@GetMapping("/logout")
public String logout(HttpSession session) { 
        session.invalidate();
        return "redirect:/";

}
@GetMapping("/ProgrammerDashboard")
public String home(Model model, HttpSession session) {
    if (session.getAttribute("Prog_id") != null) {
    Long Prog_id = (Long) session.getAttribute("Prog_id");
    Programmer thisProgrammer = progServ.get(Prog_id);
    model.addAttribute("thisProg", thisProgrammer);
    return "programmers/dashboard.jsp";
}
    else {
        return "redirect:/LoginForProg";
    }
    
}




}


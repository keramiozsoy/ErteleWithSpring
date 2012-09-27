package net.ertele.spring;

import java.util.Locale;

import javax.validation.Valid;


import net.ertele.spring.domain.User;
import net.ertele.spring.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @author Fatih ISIK
 *
 */

@Controller
@SessionAttributes("user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String mainPage(Locale locale){
		
		return "main";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(ModelMap model, Locale locale){
		
		model.addAttribute("user", new User());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPage(@ModelAttribute("user") User user,Errors errors, ModelMap model){
		
		user = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if (user == null) {
			errors.reject("NotFound.user");
			return "login";
		}
		model.addAttribute(user);
		return "login";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerPage(ModelMap model){
		model.addAttribute(new User());
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPage(@Valid User user, BindingResult result){
		
		if (result.hasErrors()) {
			return "register";
		}
		// first time we do not use userName
		user.setUserName(user.getEmail());
		try {
			userService.save(user);
		} catch (Exception e) {
			result.addError(new ObjectError("NotFound.user", "user not found"));
		}
		return "register";
	}
	
}

package net.ertele.spring;

import java.util.Locale;

import javax.validation.Valid;

import net.ertele.spring.domain.User;
import net.ertele.spring.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Fatih ISIK
 *
 */

@Controller
public class ReadController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage(Locale locale){
		
		return "main";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginPage(Locale locale){
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPage(@RequestParam("email") String email, 
							@RequestParam("password") String password){
		
		User user = userService.findByEmailAndPassword(email, password);
		if (user == null) {
			return "login";
		}
		return "main";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerPage(ModelMap model){
		
		model.addAttribute("user", new User());
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPage(@Valid User user, BindingResult result){
		
		if (result.hasErrors()) {
			return "register";
		}
		// first time we do not use userName
		user.setUserName(user.getEmail());
		userService.save(user);
		return "register";
	}
	
	@RequestMapping(value="/help", method=RequestMethod.GET)
	public String helpPage(Locale locale){
		
		return "help";
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String contactPage(Locale locale){
		
		return "contact";
	}
	
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String aboutPage(Locale locale){
		
		return "about";
	}
}

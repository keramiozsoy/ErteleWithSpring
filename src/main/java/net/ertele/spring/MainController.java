package net.ertele.spring;

import java.util.Locale;

import net.ertele.spring.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Fatih ISIK
 *
 */

@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mainPage(Locale locale){
		
		return "main";
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

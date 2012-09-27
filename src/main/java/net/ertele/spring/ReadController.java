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
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String mainPage(Locale locale){
		
		return "main";
	}
	
}

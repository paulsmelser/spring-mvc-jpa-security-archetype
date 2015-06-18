package it.pkg.controller;

import it.pkg.repositories.PersonRepository;
import it.pkg.service.UdpListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


	private final PersonRepository personRepository;
	private final UdpListener udpListener;

	@Autowired
	public HomeController(PersonRepository personRepository,
						  @Qualifier("calAmpUdpListenerBuilder") UdpListener udpListener) {
		this.personRepository = personRepository;
		this.udpListener = udpListener;
	}

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	@PreAuthorize("hasRole('USER')")
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("msg_error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		model.addObject("msg_heading", "Login");
		model.setViewName("login");

		return model;

	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("msg_error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.addObject("msg_heading", "Login");
		model.setViewName("login");

		return model;
	}

	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("username", userDetail.getUsername());
		}

		model.setViewName("403");
		return model;

	}
}

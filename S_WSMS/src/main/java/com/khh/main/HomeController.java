package com.khh.main;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khh.User.Dao.UserDao;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="userDaoImpl")
	UserDao userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("schedule Login");
		
		return "SCHEDULE/USER/Login";
	} 
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public String main(Model model) {
		logger.info("schedule Login");
		
		return "SCHEDULE/USER/Login";
	}
	
	//RequestMehtod를 GET으로 해야만함
	@RequestMapping(value="/Login", method = RequestMethod.GET)
	public String Login(Model model){
		
		logger.info("schedule main");
		//로그인 아이디 가져오기.
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("User",userDao.getUser(auth.getName()));
				
		return "redirect:SPMS";
	}
	
	@RequestMapping(value="/Test1")
	public @ResponseBody Map<?,?> listJson(ModelMap model)throws Throwable{
		logger.info("Ajax1");
		model.put("results", userDao.getAllUsers());
		
		return model;
	}
	
	@RequestMapping(value = "/admin")
	public String Test(ModelMap model) {
		logger.info("admin");
		
		model.addAttribute("User", userDao.getAllUsers());
		
		return "admin";
	}
}

package com.khh.User;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.khh.User.Dao.UserDao;
import com.khh.User.Domain.UserVo;
import com.khh.User.Service.UserJoinService;

@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource(name="userDaoImpl")
	UserDao userDao;
	
	@Resource(name="userJoinService")
	UserJoinService userJoinService;
	
	
	@RequestMapping(value="/UserJoinForm",method=RequestMethod.GET)
	public String UserJoinForm(Model model){
		logger.info("display view UserJoinForm");
		
		return "SCHEDULE/USER/UserJoinForm";
	}
	
	@RequestMapping(value="/CheckUserId",method=RequestMethod.GET)
	public String CheckUserId(@RequestParam(value="USER_ID",defaultValue="0")String USER_ID,Model model){
		logger.info("display view CheckUserId User_id={}",USER_ID);
		
		int bCheck_id = this.userDao.bCheck_id(USER_ID);
		
		model.addAttribute("bCheck_id",bCheck_id);
		model.addAttribute("USER_ID",USER_ID);
		
		return "SCHEDULE/USER/CheckUserId";
	}
	
	@RequestMapping(value="/UserJoin",method=RequestMethod.POST)
	public String JoinUser(@ModelAttribute("userVo")UserVo user,RedirectAttributes redirectAttributes,Model model){
		logger.info("display view JoinUser");
			
		model.addAttribute("user", userJoinService.JoinUser(user));
			
		redirectAttributes.addFlashAttribute("message","추가되었습니다");
			
		return "SCHEDULE/USER/UserJoinConfirm";
	}
	
	@RequestMapping(value="/UserJoinConfirm",method=RequestMethod.GET)
	public String JoinConfrim(){
		logger.info("redirect main");
		
		return "redirect:Login";
	}
	
}

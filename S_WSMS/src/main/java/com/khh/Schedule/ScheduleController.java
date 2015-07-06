package com.khh.Schedule;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.khh.Schedule.Dao.WeekDaoImpl;
import com.khh.Schedule.Domain.WeekVo;
import com.khh.Schedule.Service.WeekService;
import com.khh.User.Dao.UserDao;

@Controller
public class ScheduleController {
	private static final Logger logger = LoggerFactory.getLogger(ScheduleController.class);
	
	@Resource(name="userDaoImpl")
	UserDao userDao;
	
	@Resource(name="weekDaoImpl")
	WeekDaoImpl weekDao;
	
	@Resource(name="weekService")
	WeekService weekService;
	
	@RequestMapping(value="SPMS",method=RequestMethod.GET)
	public String UserJoinForm(Model model){
		logger.info("display view schedule Main");
		
		//현재 로그인 아이디 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		model.addAttribute("MON_LIST",weekDao.getAllWeekSchedule(1, auth.getName()));
		model.addAttribute("TUES_LIST",weekDao.getAllWeekSchedule(2, auth.getName()));
		model.addAttribute("WEN_LIST",weekDao.getAllWeekSchedule(3, auth.getName()));
		model.addAttribute("THUR_LIST",weekDao.getAllWeekSchedule(4, auth.getName()));
		model.addAttribute("FRI_LIST",weekDao.getAllWeekSchedule(5, auth.getName()));
		model.addAttribute("SAT_LIST",weekDao.getAllWeekSchedule(6, auth.getName()));
		model.addAttribute("SUN_LIST",weekDao.getAllWeekSchedule(7, auth.getName()));
		
		return "SCHEDULE/SPMS/SPMS";
	}
	
	@RequestMapping(value="addScheduleform",method=RequestMethod.GET)
	public String AddSchedule(Model model){
		logger.info("display view schedule addForm");
		
		return "SCHEDULE/SPMS/addSchedule";
	}
	
	@RequestMapping(value="addSchedule",method=RequestMethod.POST)
	public String AddSchedule(@ModelAttribute("weekVo")WeekVo week,Model model){
		logger.info("display view schedule add");

		String login_id = SecurityContextHolder.getContext().getAuthentication().getName();
		boolean bCheck = weekDao.bCheck_schedule(login_id, week.getStart_time(), week.getEnd_time(), week.getDay());

		if(bCheck){
			model.addAttribute("overlap","true");
			
			return "SCHEDULE/SPMS/addSchedule";
		}else{
			weekDao.addWeekSchedule(week, login_id);
			
			return "redirect:SPMS";
		}
	}
	
	@RequestMapping(value="scheduleInfo",method=RequestMethod.GET)
	public String InfoSchedule(@RequestParam(value="start_time",defaultValue="0")int START_TIME,
			@RequestParam(value="day",defaultValue="0")int DAY,
			Model model){
		logger.info("display schedule info");
		String login_id = SecurityContextHolder.getContext().getAuthentication().getName();
		
		model.addAttribute("WEEK", weekDao.getWeekSchedule(DAY, START_TIME, login_id));
		
		return "SCHEDULE/SPMS/ScheduleInfo";
	}

	//시간표 수정폼 출력
	@RequestMapping(value="scheduleMod",method=RequestMethod.GET)
	public String ModScheduleForm(@RequestParam(value="start_time",defaultValue="0")int START_TIME,
			@RequestParam(value="day",defaultValue="0")int DAY,
			@RequestParam(value="now_start_time",defaultValue="0")int NOW_START_TIME,
			@RequestParam(value="now_end_time",defaultValue="0")int NOW_END_TIME,
			@RequestParam(value="now_day",defaultValue="0")int NOW_DAY,
			@ModelAttribute("weekVo")WeekVo week,
			Model model){
		logger.info("display schedule Mod Form");
		
		Map<String,Object> map 
			= weekService.ModSchedule(week, DAY, START_TIME, NOW_START_TIME, NOW_END_TIME, NOW_DAY);
		
		model.addAttribute("overlap",map.get("overlap"));
		model.addAttribute("WEEK",map.get("WEEK"));
		
		return (String)map.get("addr");
	}
	
	@RequestMapping(value="scheduleDel",method=RequestMethod.GET)
	public String DelSchedule(@RequestParam(value="start_time",defaultValue="0")int START_TIME,
			@RequestParam(value="day",defaultValue="0")int DAY,
			Model model){
		logger.info("display schedule Del Form");
		
		String login_id = SecurityContextHolder.getContext().getAuthentication().getName();
		
		weekDao.deleteSchedule(login_id, START_TIME, DAY);
		
		return "redirect:SPMS";
	}
}


package com.khh.Schedule.Service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.khh.Schedule.Dao.WeekDaoImpl;
import com.khh.Schedule.Domain.WeekVo;

@Service(value="weekService")
public class WeekService {
	@Resource(name="weekDaoImpl")
	WeekDaoImpl weekDao;
	
	public Map<String,Object> ModSchedule(WeekVo week,int DAY,int START_TIME,
			int NOW_START_TIME,int NOW_END_TIME,int NOW_DAY){
		String login_id = SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String,Object> map = new HashMap<String, Object>();  

		System.out.println(week.getTitle());
		//첫 폼 출력
		if(week.getTitle()==null){
			WeekVo get_week = weekDao.getWeekSchedule(DAY, START_TIME, login_id);
			map.put("WEEK",get_week);
			
			map.put("addr", "SCHEDULE/SPMS/scheduleMod");
		}else{
			if(week.getStart_time()==NOW_START_TIME && week.getEnd_time()==NOW_END_TIME && week.getDay()==NOW_DAY){
				//현재 앞,뒤 시간 요일 갈을때
				weekDao.updateSchedule(week, login_id, NOW_START_TIME, NOW_DAY);

				//수정
				map.put("addr", "redirect:SPMS");
			}else if(week.getStart_time()==NOW_START_TIME && week.getDay()==NOW_DAY){
				//현재 앞 요일과 갈을경우
				if(weekDao.bCheck_schedule_end(login_id, NOW_END_TIME, week.getEnd_time(), week.getDay())){
					//앞,요일은 같지만 뒤에 수정할 스케줄 뒤에 스케줄이 있음
					map.put("WEEK", weekDao.getWeekSchedule(NOW_DAY, NOW_START_TIME, login_id));
					map.put("overlap", "true");
					map.put("addr", "SCHEDULE/SPMS/scheduleMod");
				}else{
					//앞,요일 같고 뒤에도 스케줄없음
					weekDao.updateSchedule(week, login_id, NOW_START_TIME, NOW_DAY);
					
					map.put("addr", "redirect:SPMS");
				}
			}else if(week.getEnd_time()==NOW_END_TIME && week.getDay()==NOW_DAY){
				//현재 앞 요일과 갈을경우
				if(weekDao.bCheck_schedule_start(login_id, NOW_START_TIME, week.getStart_time(), week.getDay())){
					//앞,요일은 같지만 뒤에 수정할 스케줄 뒤에 스케줄이 있음
					map.put("WEEK", weekDao.getWeekSchedule(NOW_DAY, NOW_START_TIME, login_id));
					map.put("overlap", "true");
					map.put("addr", "SCHEDULE/SPMS/scheduleMod");
				}else{
					//앞,요일 같고 뒤에도 스케줄없음
					weekDao.updateSchedule(week, login_id, NOW_START_TIME, NOW_DAY);
					
					map.put("addr", "redirect:SPMS");
				}
			}else{
				//앞,뒤시간 요일 다 다를경우
				if(weekDao.bCheck_schedule(login_id, week.getStart_time(),week.getEnd_time(),week.getDay())){
					//앞뒤 시간 요일중 중복있음 
					map.put("WEEK", weekDao.getWeekSchedule(NOW_DAY, NOW_START_TIME, login_id));
					map.put("overlap", "true");
					map.put("addr", "SCHEDULE/SPMS/scheduleMod");
				}else{
					weekDao.updateSchedule(week, login_id, NOW_START_TIME, NOW_DAY);
					map.put("addr", "redirect:SPMS");
				}
			}
		}
		
		return map;
	}
}	

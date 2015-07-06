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
		//ù �� ���
		if(week.getTitle()==null){
			WeekVo get_week = weekDao.getWeekSchedule(DAY, START_TIME, login_id);
			map.put("WEEK",get_week);
			
			map.put("addr", "SCHEDULE/SPMS/scheduleMod");
		}else{
			if(week.getStart_time()==NOW_START_TIME && week.getEnd_time()==NOW_END_TIME && week.getDay()==NOW_DAY){
				//���� ��,�� �ð� ���� ������
				weekDao.updateSchedule(week, login_id, NOW_START_TIME, NOW_DAY);

				//����
				map.put("addr", "redirect:SPMS");
			}else if(week.getStart_time()==NOW_START_TIME && week.getDay()==NOW_DAY){
				//���� �� ���ϰ� �������
				if(weekDao.bCheck_schedule_end(login_id, NOW_END_TIME, week.getEnd_time(), week.getDay())){
					//��,������ ������ �ڿ� ������ ������ �ڿ� �������� ����
					map.put("WEEK", weekDao.getWeekSchedule(NOW_DAY, NOW_START_TIME, login_id));
					map.put("overlap", "true");
					map.put("addr", "SCHEDULE/SPMS/scheduleMod");
				}else{
					//��,���� ���� �ڿ��� �����پ���
					weekDao.updateSchedule(week, login_id, NOW_START_TIME, NOW_DAY);
					
					map.put("addr", "redirect:SPMS");
				}
			}else if(week.getEnd_time()==NOW_END_TIME && week.getDay()==NOW_DAY){
				//���� �� ���ϰ� �������
				if(weekDao.bCheck_schedule_start(login_id, NOW_START_TIME, week.getStart_time(), week.getDay())){
					//��,������ ������ �ڿ� ������ ������ �ڿ� �������� ����
					map.put("WEEK", weekDao.getWeekSchedule(NOW_DAY, NOW_START_TIME, login_id));
					map.put("overlap", "true");
					map.put("addr", "SCHEDULE/SPMS/scheduleMod");
				}else{
					//��,���� ���� �ڿ��� �����پ���
					weekDao.updateSchedule(week, login_id, NOW_START_TIME, NOW_DAY);
					
					map.put("addr", "redirect:SPMS");
				}
			}else{
				//��,�ڽð� ���� �� �ٸ����
				if(weekDao.bCheck_schedule(login_id, week.getStart_time(),week.getEnd_time(),week.getDay())){
					//�յ� �ð� ������ �ߺ����� 
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

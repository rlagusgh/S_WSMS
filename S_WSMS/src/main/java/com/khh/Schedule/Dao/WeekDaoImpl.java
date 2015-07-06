package com.khh.Schedule.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.khh.Schedule.Domain.WeekVo;

@Repository(value="weekDaoImpl")
public class WeekDaoImpl implements WeekDao{
	@Resource(name="weekMapper")
	private WeekMapper weekMapper;
	
	@Override
	public List<WeekVo> getAllWeekSchedule(int day, String id) {
		return this.weekMapper.getAllWeekSchedule(day, id);
	}

	@Override
	public WeekVo getWeekSchedule(int day, int start_time, String user_id) {
		return this.weekMapper.getWeekSchedule(day, start_time, user_id);
	}

	@Override
	public void addWeekSchedule(WeekVo week, String id) {
		this.weekMapper.addWeekSchedule(week, id);
	}

	@Override
	public void updateSchedule(WeekVo week, String id, int now_start_time,
			int now_day) {
		this.weekMapper.updateSchedule(week, id, now_start_time, now_day);
	}

	@Override
	public void deleteSchedule(String id, int start_time, int day) {
		this.weekMapper.deleteSchedule(id, start_time, day);
	}

	@Override
	public boolean bCheck_schedule(String id, int start_time, int end_time,
			int day) {
		int bCheck = this.weekMapper.bCheck_schedule(id, start_time, end_time, day);
		
		if(bCheck==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean bCheck_schedule_start(String id, int start_time,
			int check_time, int day) {
		int bCheck = this.weekMapper.bCheck_schedule_start(id, start_time, check_time, day);
		
		if(bCheck==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean bCheck_schedule_end(String id, int end_time, int check_time,
			int day) {
		int bCheck = this.weekMapper.bCheck_schedule_end(id, end_time, check_time, day);
		
		if(bCheck==0){
			return false;
		}else{
			return true;
		}
	}
}

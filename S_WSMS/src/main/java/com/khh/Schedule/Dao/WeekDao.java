package com.khh.Schedule.Dao;

import java.util.List;

import com.khh.Schedule.Domain.WeekVo;

public interface WeekDao {
	List<WeekVo> getAllWeekSchedule(int day,String id);
	WeekVo getWeekSchedule(int day,int start_time,String user_id);
	void addWeekSchedule(WeekVo week,String id);
	void updateSchedule(WeekVo week,String id,int now_start_time,int now_day);
	void deleteSchedule(String id,int start_time,int day);
	boolean bCheck_schedule(String id,int start_time,int end_time,int day);
	boolean bCheck_schedule_start(String id,int start_time ,int check_time, int day);
	boolean bCheck_schedule_end(String id,int end_time ,int check_time, int day);
}


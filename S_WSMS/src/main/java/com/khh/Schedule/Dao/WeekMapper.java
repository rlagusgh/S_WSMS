package com.khh.Schedule.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.khh.Schedule.Domain.WeekVo;

@Repository(value="weekMapper")
public interface WeekMapper {
	List<WeekVo> getAllWeekSchedule(@Param("DAY") int DAY,@Param("USER_ID") String USER_ID);
	WeekVo getWeekSchedule(@Param("DAY") int DAY,@Param("START_TIME") int START_TIME,@Param("USER_ID") String USER_ID);
	void addWeekSchedule(@Param("WEEK") WeekVo WEEK,@Param("USER_ID") String USER_ID);
	void updateSchedule(@Param("WEEK") WeekVo WEKK,@Param("USER_ID") String USER_ID,@Param("NOW_START_TIME") int NOW_START_TIME,@Param("NOW_DAY")int NOW_DAY);
	void deleteSchedule(@Param("USER_ID") String USER_ID,@Param("START_TIME") int START_TIME,@Param("DAY") int DAY);
	int bCheck_schedule(@Param("USER_ID") String USER_ID,@Param("START_TIME") int START_TIME,@Param("END_TIME") int END_TIME,@Param("DAY") int DAY);
	int bCheck_schedule_start(@Param("USER_ID") String USER_ID,@Param("START_TIME") int start_time ,@Param("CHECK_TIME") int check_time,@Param("DAY") int day);
	int bCheck_schedule_end(@Param("USER_ID") String USER_ID,@Param("END_TIME") int END_TIME ,@Param("CHECK_TIME") int CHECK_TIME,@Param("DAY") int DAY);	
}

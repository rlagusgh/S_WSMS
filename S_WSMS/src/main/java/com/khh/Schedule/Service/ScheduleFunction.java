package com.khh.Schedule.Service;

import com.khh.Schedule.Domain.DAY;

public class ScheduleFunction {
	public static String getKorDay(int day){
	    return DAY.getDay(day).getKorDay();
	}
	
	public static String getTime(int start_time){
		int time=8;
		String minute = ":00";
		
		for(int i=1;i<25;i++){
			if(i%2==0){
				minute = ":30";
			}else{
				minute= ":00";
				time+=1;
			}
			
			if(start_time == i)
				return time+minute;
		}
		
		return "";
	}
}

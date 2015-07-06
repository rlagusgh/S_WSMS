package com.khh.Schedule.Domain;

public enum DAY {
	MON(1,"월요일"),TUES(2,"화요일"),WEN(3,"수요일"),THUR(4,"목요일"),FRI(5,"금요일"),SAT(6,"토요일"),SUN(7,"일요일");
	
	private final int day;
	private final String kor_day;
	
	DAY(int day,String kor_day){
		this.day=day;
		this.kor_day = kor_day;
	}
	
	public String getKorDay(){
		return this.kor_day;
	}
	
	public int intValue(){
		return day;
	}
	
	public static DAY getDay(int day){
		switch (day) {
		case 1:
			return DAY.MON;
		case 2:
			return DAY.TUES;
		case 3:
			return DAY.WEN;
		case 4:
			return DAY.THUR;
		case 5:
			return DAY.FRI;
		case 6:
			return DAY.SAT;
		case 7:
			return DAY.SUN;
		default:
			throw new AssertionError();
		}
	}
}

package com.khh.Schedule.Domain;

public enum DAY {
	MON(1,"������"),TUES(2,"ȭ����"),WEN(3,"������"),THUR(4,"�����"),FRI(5,"�ݿ���"),SAT(6,"�����"),SUN(7,"�Ͽ���");
	
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

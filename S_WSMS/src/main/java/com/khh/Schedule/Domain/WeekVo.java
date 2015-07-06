package com.khh.Schedule.Domain;

public class WeekVo {
	String USER_ID;
	String TITLE;
	String CONTENTS;
	int DAY;
	int START_TIME;
	int END_TIME;
	int ALRAM;
	String CLASS_ROOM;
	String COLOR;
	
	public WeekVo() {
		super();
	}

	public WeekVo(String user_id, String title, String contents, int day,
			int start_time, int end_time, int alram, String class_room,
			String color) {
		super();
		this.USER_ID = user_id;
		this.TITLE = title;
		this.CONTENTS = contents;
		this.DAY = day;
		this.START_TIME = start_time;
		this.END_TIME = end_time;
		this.ALRAM = alram;
		this.CLASS_ROOM = class_room;
		this.COLOR = color;
	}

	public String getUser_id() {
		return USER_ID;
	}

	public WeekVo setUser_id(String user_id) {
		this.USER_ID = user_id;
		return this;
	}

	public String getTitle() {
		return TITLE;
	}

	public WeekVo setTitle(String title) {
		this.TITLE = title;
		return this;
	}

	public String getContents() {
		return CONTENTS;
	}

	public WeekVo setContents(String contents) {
		this.CONTENTS = contents;
		return this;
	}

	public int getDay() {
		return DAY;
	}

	public WeekVo setDay(int day) {
		this.DAY = day;
		return this;
	}

	public int getStart_time() {
		return START_TIME;
	}

	public WeekVo setStart_time(int start_time) {
		this.START_TIME = start_time;
		return this;
	}

	public int getEnd_time() {
		return END_TIME;
	}

	public WeekVo setEnd_time(int end_time) {
		this.END_TIME = end_time;
		return this;
	}

	public int getAlram() {
		return ALRAM;
	}

	public WeekVo setAlram(int alram) {
		this.ALRAM = alram;
		return this;
	}

	public String getClass_room() {
		return CLASS_ROOM;
	}

	public WeekVo setClass_room(String class_room) {
		this.CLASS_ROOM = class_room;
		return this;
	}

	public String getColor() {
		return COLOR;
	}

	public WeekVo setColor(String color) {
		this.COLOR = color;
		return this;
	}
}

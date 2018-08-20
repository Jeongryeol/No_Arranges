package com.ch7;

public class Encaps_TimeVO {
	
	public String name = "WHO R YOU?";
	
	private	int	year	= 0;
	private	int	month	= 0;
	private	int	date	= 0;
	private	int	hour	= 0;
	private	int	minute	= 0;
	private	int	second	= 0;
	
	public int getMonth() {return month;}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDate() {return date;}
	public void setDate(int date) {
		this.date = date;
	}
	public int getHour() {return hour;}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {return minute;}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {return second;}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getYear() {return year;}
	public void setYear(int year) {
		this.year = year;
	}
}

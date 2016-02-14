package theTimeLord;

import java.util.Date;

public class Time {
	private int hour;
	private int minutes;
	private int seconds;
	private int date;
	private int month;
	private int year;
	
	
	public Time(){}
	
	public Time(int hour,int minutes,int seconds,int date,int month,int year){
		this.hour=hour; this.minutes=minutes; this.seconds=seconds;
		this.date=date; this.month=month; this.year=year;
	}
	
	public String toString(){
		String str =String.format("%02d:%02d:%02d %02d.%02d.%d", hour,minutes,seconds,date,month,year);
		return str;
		
	}
	public void now(){	 
		  Date date = new Date();
	      String str =String.format("Today is %tT %<td.%<tm.%<ty", date);
	      System.out.printf(str);
	}
   
	public static void main(String[] args){
		Time t=new Time();
		Time custTime=new Time(2,27,33,15,2,15);
		System.out.println(custTime);
		t.now();
	}
    

}

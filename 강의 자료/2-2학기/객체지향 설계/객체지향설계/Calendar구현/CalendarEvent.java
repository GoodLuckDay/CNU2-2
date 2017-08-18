import java.util.*;
public class CalendarEvent {
	Date d = null;
	String event =null;
	public CalendarEvent(){
		d = new Date();
		event =null;
	}
	@SuppressWarnings("deprecation")
	public CalendarEvent(int year,int month,int day,String event){
		d = new Date(year, month, day);
		this.event = event;
	}
	@SuppressWarnings("deprecation")
	public String toString(){
		return d.getYear() + " : " + d.getMonth() +" : "+d.getDate()+" - "+event;
	}
	
	
	
}

import java.util.*;
public class CalendarEventPlus extends CalendarEvent {
	String spot;
	public CalendarEventPlus(){
		super();
		spot = null;
	}
	public CalendarEventPlus(int year,int month,int day,String spot,String event){
		super(year,month,day,event);
		this.spot = spot;
	}
	public String toString(){
		return d.getYear() + " : " + d.getMonth() +" : "+d.getDate()+"  (site :"+spot+")"+ " - "+event;
	}
}

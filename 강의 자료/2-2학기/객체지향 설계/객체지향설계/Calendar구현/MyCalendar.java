import java.util.*;

public class MyCalendar {
	CalendarEvent[] cal = null;
	int size;
	public MyCalendar(){
		cal = new CalendarEvent[5];
		this.size = 0;
	}
	
	void add(int year, int month, int day, String event){
		cal[this.size] = new CalendarEvent(year,month,day,event);
		this.size++;
		
	}
	void add(int year,int month, int day, String spot,String event){
		cal[this.size] = new CalendarEventPlus(year,month,day,spot,event);
		this.size++;
	}
	void del(int year, int month, int day){
		int search;
		boolean found = false;
		for(search =0; search<this.size && !found;search++){
			if((cal[search].d.getYear() == year && cal[search].d.getMonth() == month) && cal[search].d.getDate() == day){
				found = true;
			}
		}
		if(!found)
			System.out.println("일치하는 일정이 없습니다. ");
		else{
		search = search-1;
		for(int i= search;i<this.size-1;i++){
			cal[i] = cal[i+1];
			}
		cal[size-1] = null;
		this.size--;
		}
		
	}
	@SuppressWarnings("deprecation")
	void printEvent(int year, int month, int day){
		boolean found = false;
		for(int i=0;i<this.size && !found;i++){
			if((cal[i].d.getYear() == year && cal[i].d.getMonth() == month) && cal[i].d.getDate() == day){
				System.out.println(cal[i]);
				found = true;
			}
		}
		if(!found)
		System.out.println("일치하는 일정이 없습니다.");
	}
	@SuppressWarnings("deprecation")
	void printMatchEvent(String event){
		for(int i=size-1;i>=0;i--){
			if(cal[i].event.contains(event)){
				System.out.println(cal[i]);
			}
		}
	}
}

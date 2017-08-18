
public class CalendarTest {

	public static void main(String[] args) {
		MyCalendar c = new MyCalendar();
		
		c.add(2016, 8, 24, "병원 정기 검진");
		c.add(2016, 9, 1, "2학기 개강, 알고리즘 강의");
		c.add(2016, 9, 21,"학교", "객체 지향 설계 강의 ");
		
		c.del(2016, 8, 24);
		
		c.printEvent(2016, 9, 1);
		c.printEvent(2016, 9, 21);
		c.printEvent(2016, 9, 24);
		
		c.printMatchEvent("강의");
	}

}

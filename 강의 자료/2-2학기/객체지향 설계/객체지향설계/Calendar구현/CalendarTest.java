
public class CalendarTest {

	public static void main(String[] args) {
		MyCalendar c = new MyCalendar();
		
		c.add(2016, 8, 24, "���� ���� ����");
		c.add(2016, 9, 1, "2�б� ����, �˰��� ����");
		c.add(2016, 9, 21,"�б�", "��ü ���� ���� ���� ");
		
		c.del(2016, 8, 24);
		
		c.printEvent(2016, 9, 1);
		c.printEvent(2016, 9, 21);
		c.printEvent(2016, 9, 24);
		
		c.printMatchEvent("����");
	}

}

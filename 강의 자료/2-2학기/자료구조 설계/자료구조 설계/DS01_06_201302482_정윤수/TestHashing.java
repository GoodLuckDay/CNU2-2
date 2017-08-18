import java.util.*;
import java.io.*;

public class TestHashing {

	public static void main(String[] args) throws IOException {
		
		LinearProbing s1 = new LinearProbing();
		QuadraticProbing s2 = new QuadraticProbing();
		DoubleHashing s3 = new DoubleHashing();
		SeparateChaining s4 = new SeparateChaining();
		BufferedReader br= new BufferedReader(new FileReader("Caesar.txt"));
		String line = br.readLine();
		while(line != null){
		StringTokenizer parser = new StringTokenizer(line,", . ; ?");
		while(parser.hasMoreTokens()){
			String word = parser.nextToken();
			s1.put(word.toLowerCase(), 1);
			s2.put(word.toLowerCase(), 1);
			s3.put(word.toLowerCase(), 1);
			s4.put(word.toLowerCase(), 1);
			}
		line = br.readLine();
		}
	    s1.printCount();
	    s2.printCount();
	    s3.printCount();
	    s4.printCount();
	    System.out.println("I : " +s1.get(new String("I").toLowerCase()));
	    System.out.println("You : " +s1.get(new String("You").toLowerCase()));
	    System.out.println("he : " +s1.get(new String("He").toLowerCase()));
	    System.out.println("Brutus : " +s1.get(new String("Brutus").toLowerCase()));
	    System.out.println("evil : " +s1.get(new String("evil").toLowerCase()));
	    System.out.println("the : " +s1.get(new String("the").toLowerCase()));
	    System.out.println("and : " +s1.get(new String("and").toLowerCase()));
	    
	}
}
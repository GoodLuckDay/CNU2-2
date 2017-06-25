import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;



public class TestHashMap{

	public static void main(String[] args) throws IOException {
		HashMap m1 = new HashMap();
		BufferedReader br= new BufferedReader(new FileReader("Caesar.txt"));
		String line = br.readLine();
		while(line != null){
		StringTokenizer parser = new StringTokenizer(line,", . ; ?");
			while(parser.hasMoreTokens()){
			String word = parser.nextToken();
			if(m1.containsKey(word.toLowerCase())){
				m1.replace(word.toLowerCase(),(int)m1.get(word.toLowerCase())+1 );
			}
			else
				m1.put(word.toLowerCase(), 1);
			}
		line = br.readLine();
		}
		System.out.println("I\t:"+ m1.get(new String("I").toLowerCase()));
		System.out.println("You\t:"+ m1.get(new String("You").toLowerCase()));
		System.out.println("he\t:"+ m1.get(new String("he").toLowerCase()));
		System.out.println("Brutus\t:"+ m1.get(new String("Brutus").toLowerCase()));
		System.out.println("evil\t:"+ m1.get(new String("evil").toLowerCase()));
		System.out.println("the\t:"+ m1.get(new String("the").toLowerCase()));
		System.out.println("and\t:"+ m1.get(new String("and").toLowerCase()));


	}

}

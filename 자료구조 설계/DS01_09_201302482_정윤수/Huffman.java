import java.util.*;
public class Huffman{
	HashMap<Character,Integer> map = new HashMap<>();
	HashMap<Character, String> map2 = new HashMap<>();
	HeapPriorityQueue pri = new HeapPriorityQueue();
	StringBuffer text = new StringBuffer();
	StringBuffer incodingText = new StringBuffer();
	public void frequency(String str){
		for(int i=0;i<str.length();i++){
		char alpha = str.toUpperCase().charAt(i);
		text.append(alpha);
		if(map.containsKey(alpha)){
		map.replace(alpha, (int)map.get(alpha)+1);
			}
		else
		map.put(alpha, 1);
		}
	}
	public void printIncodingText(){
		System.out.println("<<<<< Text Encoding >>>>>");
		for(int i=0;i<text.length();i++){
			incodingText.append(map2.get(text.charAt(i)));
		}
		for(int i=0;i<incodingText.length();i++){
			System.out.print(incodingText.charAt(i));
			if(i%80 == 60)
				System.out.println("");
		}
		System.out.println("\n필요한 총 비트의 수 : "+ incodingText.length());
	}
	public void makeTree(){
		for(Map.Entry<Character, Integer> m: map.entrySet()){
			pri.add(m.getKey().charValue(),m.getValue().intValue());
		}
		while(pri.size() >1){
			int t1 = pri.best().freq;
			HeapPriorityQueue.trecord m1 = pri.remove();
			int t2 = pri.best().freq;
			HeapPriorityQueue.trecord m2 = pri.remove();
			pri.add(' ', t1+t2,m1,m2);
		}
		
	}
	public String printFreq(){
		System.out.println("<<<<< Frequency >>>>> ");
		for(Map.Entry<Character, Integer> m : map.entrySet()){
			System.out.println(m.getKey() + " : "+ m.getValue());
		}
		return "";
	}
	public String printhufcode(){
		pri.preOrder(pri.best(),map2);
		System.out.println("<<<<< Frequency >>>>> ");
		for(Map.Entry<Character, String> m : map2.entrySet()){
			System.out.println(m.getKey() + " : "+ m.getValue());
		}
		return "";
	}
	
	
	
}

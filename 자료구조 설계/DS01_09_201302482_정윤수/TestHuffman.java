import java.io.*;
import java.util.*;
public class TestHuffman {
	public static void main(String[] args) throws IOException {
		Huffman huf = new Huffman();
		BufferedReader br= new BufferedReader(new FileReader("Huffman.txt"));
		String line = br.readLine();
		while(line != null){
		StringTokenizer parser = new StringTokenizer(line,", . ; ?");
			while(parser.hasMoreTokens()){
			String word = parser.nextToken();
			huf.frequency(word);
			}
		line = br.readLine();
		}
		System.out.print(huf.printFreq());
		huf.makeTree();
		System.out.print(huf.printhufcode());
		huf.printIncodingText();
	}
}

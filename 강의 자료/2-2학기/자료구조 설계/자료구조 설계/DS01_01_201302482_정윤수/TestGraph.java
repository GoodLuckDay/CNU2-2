import java.util.*;
import java.io.*;

public class TestGraph {

	public static void main(String[] args) throws IOException {
		int numOfedges=0;
		int numOfvertex=0;
		String[] vertexList=null;
		BufferedReader br= new BufferedReader(new FileReader("Graph.txt"));
		String line = br.readLine();
		StringTokenizer parser = new StringTokenizer(line);
		numOfvertex = Integer.parseInt(parser.nextToken());
		numOfedges = Integer.parseInt(parser.nextToken());
		line = br.readLine();
		parser = new StringTokenizer(line);
		vertexList = new String[numOfvertex];
		for(int i=0;i<numOfvertex;i++){
			vertexList[i]=parser.nextToken();
		}
		Graph g = new Graph(vertexList);
		line = br.readLine();
		for(int i=0;i<numOfedges && line != null;i++){	
		parser = new StringTokenizer(line);
		g.add(parser.nextToken(),parser.nextToken());
		line = br.readLine();
		}
		System.out.println(g);
	}

	
}



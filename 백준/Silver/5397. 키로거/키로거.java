import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		
		while(n --> 0) {
			LinkedList<Character> linkList = new LinkedList<>();
			ListIterator<Character> iterator = linkList.listIterator();
			StringBuffer sub = new StringBuffer();
			
			String str = br.readLine();
			char[] order = str.toCharArray();
			for(char c : order) {
				switch(c) {
				case '<':
					if(iterator.hasPrevious()) {
						iterator.previous();
					}
					break;
				case '>':
					if(iterator.hasNext()) {
						iterator.next();
					}
					break;
				case '-':
					if(iterator.hasPrevious()) {
						iterator.previous();
						iterator.remove();
					}
					break;
				default:
					iterator.add(c);
					break;
				}
			}
			
			for(char c : linkList) {
				sub.append(c);
			}
			
			sb.append(sub.toString()).append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
}
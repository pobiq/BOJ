import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		String[] sub = str.split("-");
		List<Integer> list = new ArrayList<Integer>();
		int answer = 0;
		
		for(String s : sub) {
			String[] main = s.split("\\+");
			int sum = 0;
			for(String n : main) {
				sum += Integer.parseInt(n);
			}
			list.add(sum);
		}
		
		for(int i=0; i<list.size(); i++) {
			if(i == 0) {
				answer += list.get(i);
			} else {
				answer -= list.get(i);
			}
		}
		
		
		bw.write(Integer.toString(answer));
		
		
		bw.flush();
		bw.close();
		
	}
	
}
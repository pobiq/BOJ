import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		
		String[] array = br.readLine().split(" ");
		
		String v = br.readLine();
		
		for(String str : array) {
			if(str.equals(v)) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
}
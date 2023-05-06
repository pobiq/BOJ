import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		StringBuffer[] wheels = new StringBuffer[5];
		
		for(int i=1; i<=4; i++) {
			wheels[i] = new StringBuffer(br.readLine());
		}
		
		int k = Integer.parseInt(br.readLine());
		int result = 0;
		
		while(k --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			int left = number;
			int right = number;
			
			int[] directions = new int[5];
			
			if(number % 2 == 1) {
				for(int i=1; i<=4; i++) {
					if(i % 2 == 1) {
						directions[i] = dir;
					} else {
						directions[i] = -dir;
					}
				}
			} else {
				for(int i=1; i<=4; i++) {
					if(i % 2 == 1) {
						directions[i] = -dir;
					} else {
						directions[i] = dir;
					}
				}
			}
			
			boolean[] flag = new boolean[5];
			flag[number] = true;
			
			while(left > 1) {
				if(wheels[left].charAt(6) != wheels[left-1].charAt(2)) {
					flag[--left] = true;
				} else {
					break;
				}
			}
			
			while(right <= 3) {
				if(wheels[right].charAt(2) != wheels[right+1].charAt(6)) {
					flag[++right] = true;
				} else {
					break;
				}
			}
			
			for(int i=1; i<=4; i++) {
				if(flag[i]) {
					rotate(wheels[i], directions[i]);
				}
			}
			
		}
		
		for(int i=1; i<=4; i++) {
			char c = wheels[i].charAt(0);
			if(c == '1') {
				result += Math.pow(2, i-1);
			}
		}
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void rotate(StringBuffer wheel, int dir) {
		if(dir == -1) {
			char c = wheel.charAt(0);
			wheel.deleteCharAt(0);
			wheel.append(c);
		} else {
			char c = wheel.charAt(7);
			wheel.deleteCharAt(7);
			wheel.insert(0, c);
		}
		
	}
	
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		String[] nCards = br.readLine().split(" ");
		int[] nArray = new int[N];
		
		int M = Integer.parseInt(br.readLine());
		String[] mCards = br.readLine().split(" ");
		
		for(int i=0; i<N; i++) {
			nArray[i] = Integer.parseInt(nCards[i]);
		}
		
		Arrays.sort(nArray);
		
		for(int i=0; i<M; i++) {
			int number = Integer.parseInt(mCards[i]);
			sb.append(find_right(nArray, number) - find_left(nArray, number)+ " ");
		}
		
		System.out.println(sb);
		
	}
	
	private static int find_left(int[] array, int key) {
		int left = 0;
		int right = array.length;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(key <= array[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	private static int find_right(int[] array, int key) {
		int left = 0;
		int right = array.length;
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(key < array[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
}

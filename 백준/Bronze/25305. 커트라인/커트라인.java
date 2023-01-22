import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String first = br.readLine();
        int[] array = new int[10001];
        
        int N = Integer.parseInt(first.split(" ")[0]);
        int k = Integer.parseInt(first.split(" ")[1]);
        int count = 0;
        int result = 0;
        
        String second = br.readLine();
        String[] score = second.split(" ");
        
        for(int i=0; i<N; i++) {
        	array[Integer.parseInt(score[i])]++;
        }
        
        int i = array.length-1;
        
        while(true) {
        	
        	if(array[i] != 0) {
        		count++;
        		array[i]--;
        		if(count == k) {
        			result = i;
        			break;
        		}
        	} else {
        		i--;
        	}
        }
        	
        System.out.println(result);
        
		br.close();
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        
        List<Integer> list = new ArrayList<>();
        
        int n = Integer.parseInt(str.split(" ")[0]);
        int k = Integer.parseInt(str.split(" ")[1]);
        
        for(int i=1; i<n+1; i++) {
        	list.add(i);
        }
        
        int index = k-1;
        
        bw.append("<");
        
        
        while(true) {
        	
        	String number = Integer.toString(list.get(index));
        	
        	bw.append(number);
        	if(list.size() != 1) {
        		bw.append(", ");
        	}
        	
        	list.remove(index);
        	
        	if(list.isEmpty()) {
        		break;
        	}
        	
        	index += (k-1);
        	index %= list.size();
        	
        }
        
        bw.append(">");
        
        bw.flush();
		br.close();
		bw.close();
	}
	
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
	
	public static void main(String[] args) throws Exception {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
        	
        	String str = br.readLine();
        	System.out.println(solution(str));
        	
        }
        
		br.close();
	}
	
	
	public static String solution(String str) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int j=0; j<str.length(); j++) {
    		if(str.charAt(j) == '(') {
    			stack.push('(');
    		} else {
    			if(stack.isEmpty()) {
    				return "NO";
    			}
    			stack.pop();
    		}
    	}
		
		
		return stack.isEmpty() ? "YES" : "NO";
	}
}
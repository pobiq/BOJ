import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		while(true) {
			String str = br.readLine();
			
			if(str.equals(".")) {
				break;
			}
			
			Stack<String> stack = new Stack<String>();
			
			boolean flag = true;
			
			for(int i=0; i<str.length(); i++) {
				String text = Character.toString(str.charAt(i));
				
				if(text.equals("(") || text.equals("[")) {
					stack.push(text);
				} else if(text.equals(")")) {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					
					if(stack.peek().equals("(")) {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				} else if(text.equals("]")) {
					if(stack.isEmpty()) {
						flag = false;
						break;
					}
					
					if(stack.peek().equals("[")) {
						stack.pop();
					} else {
						flag = false;
						break;
					}
				}
			}
			
			if(stack.size() > 0) {
				flag = false;
			}
			
			if(flag) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}
		}
		
		
		System.out.println(sb);
		
	}
	

}
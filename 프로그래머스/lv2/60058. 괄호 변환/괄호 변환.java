import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = recursive(p);
        
        return answer;
    }
    
    static String recursive(String w) {
		
		//1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
		
		if(w.equals("")) return "";
		
		//2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
		String[] temp = separate(w);
		String u = temp[0];
		String v = temp[1];
		
		// 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
		if(isCorrect(u)) {
			String c3 = recursive(v);
			//3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
			StringBuffer case3 = new StringBuffer();
			case3.append(u).append(c3);
			return case3.toString();
		}
		//4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
		else {
			
			//4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
			StringBuffer case4 = new StringBuffer();
			case4.append("(");
			
			//4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
			String case42 = recursive(v);
			case4.append(case42);
			
			//4-3. ')'를 다시 붙입니다.
			case4.append(")");
			
			//4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
			StringBuffer c4 = new StringBuffer(u);
			c4.deleteCharAt(0);
			c4.deleteCharAt(c4.length()-1);
			
            for(int i=0; i<c4.length(); i++) {
				if(c4.charAt(0) == '(') {
					c4.append(")");
				} else {
					c4.append("(");
				}
				c4.deleteCharAt(0);
			}
            
			case4.append(c4);
			
			//4-5. 생성된 문자열을 반환합니다.
			return case4.toString();
		}
	}
	
	static String[] separate(String p) {
		String[] result = new String[2];
		
		Stack<Character> stack = new Stack<>();
		stack.push(p.charAt(0));
		int index = 1;
		
		for(int i=1; i<p.length(); i++) {
			
			if(stack.peek() != p.charAt(i)) {
				stack.pop();
			} else {
				stack.push(p.charAt(i));
			}
			
			if(stack.isEmpty()) {
				index = i;
				break;
			}
		}
		
		result[0] = p.substring(0, index+1);
		result[1] = p.substring(index+1, p.length());
		
		
		return result;
	}
	
	static boolean isCorrect(String u) {
		
		boolean flag = false;
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<u.length(); i++) {
			if(stack.isEmpty()) {
				stack.push(u.charAt(i));
			} else {
				if(stack.peek() == '(') {
					if(u.charAt(i) == ')') {
						stack.pop();
					} else {
						stack.push(u.charAt(i));
					}
				} else {
					stack.push(u.charAt(i));
				}
			}
		}
		
		if(stack.isEmpty()) {
			flag = true;
		}
		
		return flag;
	}
    
}
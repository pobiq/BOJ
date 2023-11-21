import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        boolean flag = true;
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        
        if (stack.isEmpty() && flag) {
            answer = true;
        } else {
            answer = false;
        }
        
    

        return answer;
    }
}
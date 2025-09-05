import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<s.length(); i++) {
			if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				stack.pop();
				continue;
			}
			stack.add(s.charAt(i));
		}
		
		
		answer = stack.isEmpty() == true ? 1 : 0;

        return answer;
    }
}
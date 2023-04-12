class Solution {
    public int solution(String name) {
        int answer = 0;
		int length = name.length();
		int move = length -1;
		
		
		for(int i=0; i<length; i++) {
			char c = name.charAt(i);
			if(c < 'N') {
				answer += c - 'A';
			} else {
				answer += 'Z' - c + 1;
			}
			
			int index = i+1;
			
			while(index < length && name.charAt(index) == 'A') {
				index++;
			}
			
			// 
			move = Math.min(move, i*2 + length - index);
			
			// 
			move = Math.min(move, (length - index) *2 + i);
			
		}
		
		
		answer = answer + move;
        
        return answer;
    }
}
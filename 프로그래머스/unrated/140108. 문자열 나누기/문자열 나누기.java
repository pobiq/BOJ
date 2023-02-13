class Solution {
    public int solution(String s) {
        int answer = 0;
        
        while(s.length() != 0) {
			
			answer++;
			
			int scount = 1;
			int dcount = 0;
			char word = s.charAt(0);
			
			for(int i=1; i<s.length(); i++) {
				
				if(s.charAt(i) == word) {
					scount++;
				} else {
					dcount++;
				}
				
				if(scount == dcount) {
					break;
				}
			}
			
			s = s.substring(scount + dcount);
		}
        
        
        return answer;
    }
}
class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
		
        if(s.length() == 1) {
			answer = 1;
		}
        
		for(int i=1; i<=s.length()/2; i++) {
			StringBuffer main = new StringBuffer();
			StringBuffer sub = new StringBuffer();
			String text = s.substring(0, i);
			sub.append(text);
			int count = 1;
			for(int j=i; j<s.length(); j+=i) {
				String temp = "";
				if(j+i >= s.length()) {
					temp = s.substring(j, s.length());
				} else {
					temp = s.substring(j, j+i);
				}
				
				if(text.equals(temp)) {
					count++;
				} else {
					if(count != 1) {
						sub.insert(0, count);
					}
					main.append(sub);
					sub.delete(0, sub.length());
					text = temp;
					sub.append(text);
					count = 1;
				}
			}
			
			if(sub.length() > 0) {
				if(count != 1) {
					sub.insert(0, count);
				}
				main.append(sub);
			}
			
			if(answer > main.length()) {
				answer = main.length();
			}
		}
        
        return answer;
    }
}
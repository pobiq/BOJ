class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        char[] array = s.toCharArray();
		char[] temp = skip.toCharArray();
		int[] skipArray = new int[temp.length];
		
		for(int i=0; i<skipArray.length; i++) {
			skipArray[i] = (int) temp[i];
		}
		
		for(char c : array) {
			int value = (int) c;
			int mount = 0;
			
			
			while(mount < index) {
				value++;
				
				if(value > 122) {
					value = 97;
				}
				
				boolean flag = false;
				for(int n: skipArray) {
					if(value == n) {
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					mount++;
				}
			}
			
			answer += (char)value;
			
		}
        
        return answer;
    }
}
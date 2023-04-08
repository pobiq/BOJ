class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[] minutes = new int[1451];
		
		for(int i=0; i<book_time.length; i++) {
			String[] start_temp = book_time[i][0].split(":");
			String[] end_temp = book_time[i][1].split(":");
			
			int start_time = Integer.parseInt(start_temp[0]) * 60 + Integer.parseInt(start_temp[1]);
			int end_time = Integer.parseInt(end_temp[0]) * 60 + Integer.parseInt(end_temp[1]);
			
			minutes[start_time]++;
			minutes[end_time + 10]--;
			
		}
		
		for(int i=1; i<=1450; i++) {
			minutes[i] += minutes[i-1];
			if(answer < minutes[i]) {
				answer = minutes[i];
			}
		}
        
        
        return answer;
    }
}
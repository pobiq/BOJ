class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        int[] days = new int[progresses.length];
		int size = 0;
		int max = 0;
		int number = 0;
		int index = 0;
		
		
		for(int i=0; i<progresses.length; i++) {
			days[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);
		}
		
		for(int i=0; i<days.length; i++) {
			if(max < days[i]) {
				max = days[i];
				size++;
			}
		}
		
		answer = new int[size];
		
		max = days[0];
		for(int i=0; i<days.length; i++) {
			if(max < days[i]) {
				max = days[i];
				answer[index++] = number;
				number = 1;
			} else {
				number++;
			}
			
			if(i == days.length-1) {
				answer[index] = number;
			}
		}
        
        return answer;
    }
}
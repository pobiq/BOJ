class Solution {
    
    static int result = 0;
	static int cycle_number = -1;
	static int[] state;
	static int[] input;
    
    public int solution(int[] cards) {
        int answer = 0;
        
        int length = cards.length;
		
		input = new int[length+1];
		state = new int[length+1];
		int[] count = new int[length + 1];
		int[] max1 = new int[2];
		int[] max2 = new int[2];
		
		for(int i=1; i<input.length; i++) {
			input[i] = cards[i-1];
		}
		
		for(int i=1; i<input.length; i++) {
			run(i);
		}
		
		
		for(int i=1; i<input.length; i++) {
			count[Math.abs(state[i])]++;
		}
		
		
		for(int i=1; i<input.length; i++) {
			if(max1[1] < count[i]) {
				max1[0] = i;
				max1[1] = count[i];
			}
		}
		
		for(int i=1; i<input.length; i++) {
			if(max2[1] < count[i]) {
				if(i != max1[0]) {
					max2[0] = i;
					max2[1] = count[i];
				}
			}
		}
		
		answer = max1[1] * max2[1];
        
        return answer;
    }
    
    static void run(int start) {
		int next = start;
		while(true) {
			
			if(state[next] != 0) {
				break;
			}
			
			state[next] = start;
			next = input[next];
			
			if(state[next] == start) {
				while(state[next] != cycle_number) {
					state[next] = cycle_number;
					next = input[next];
				}
				cycle_number--;
			}
		}
	}
    
}
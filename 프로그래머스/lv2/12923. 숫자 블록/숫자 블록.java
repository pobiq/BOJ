import java.util.ArrayList;
import java.util.List;


class Solution {
    public int[] solution(long begin, long end) {
        
        int size = (int)(end-begin+1);
		
		int[] answer = new int[size];
		
		int index= 0;
		for(int i=(int)(begin); i<=end; i++) {
			answer[index++] = getMaxDivisor(i); 
		}
        
        return answer;
    }
    
    static int getMaxDivisor(int number) {
		if(number == 1) {
			return 0;
		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=2; i<=Math.sqrt(number); i++) {
			if(number % i == 0) {
				list.add(i);
				if (number / i <= 10000000) {
                    return number/i;
                }
			}
		}
		
		if(list.size() > 0) {
			return list.get(list.size()-1);
		}
		
		return 1;
	}
    
}
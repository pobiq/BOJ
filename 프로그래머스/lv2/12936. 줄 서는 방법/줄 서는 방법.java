import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
		
		ArrayList<Integer> list = new ArrayList<>();
		long fn = 1;
		
		for(int i=1; i<=n; i++) {
			fn *= i;
			list.add(i);
		}
		
		k--;
		int index = 0;
		
		while(n > 0) {
			fn /= n;
			int value = (int) (k / fn);
			answer[index++] = list.get(value);
			list.remove(value);
			k %= fn;
			n--;
		}
        
        return answer;
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
		
		HashSet<Integer> hs = new HashSet<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		hs.add(topping[0]);
		for(int i=1; i<topping.length; i++) {
			hm.put(topping[i], hm.getOrDefault(topping[i], 0) + 1);
		}
		
		for(int i=1; i<topping.length; i++) {
			hs.add(topping[i]);
			hm.put(topping[i], hm.get(topping[i]) - 1);
			if(hm.get(topping[i]) == 0) {
				hm.remove(topping[i]);
			}
			
			if(hs.size() == hm.size()) answer++;
		}
        
        return answer;
    }
}
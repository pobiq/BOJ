import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
		List<Integer> index = new ArrayList<>();
		
		
		for(int i=0; i<priorities.length; i++) {
			list.add(priorities[i]);
			index.add(i);
		}
		
		
		while(true) {
			
			if(list.size() == 1) {
				return ++answer;
			}
			
			int max = list.get(0);
			for(int i=1; i<list.size(); i++) {
				if(max < list.get(i)) {
					list.add(list.get(0));
					list.remove(0);
					index.add(index.get(0));
					index.remove(0);
					break;
				}
				
				if(i == list.size()-1) {
					answer++;
					if(index.get(0) == location) {
						return answer;
					}
					
					list.remove(0);
					index.remove(0);
				}
				
			}
        }
    }
}
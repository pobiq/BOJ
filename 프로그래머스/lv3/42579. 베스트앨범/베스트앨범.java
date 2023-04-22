
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int i=0; i<genres.length; i++) {
			String key = genres[i];
			int play = plays[i];
			hm.put(key, hm.getOrDefault(key, 0) + play);
		}
		
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(hm.entrySet());
		
		Collections.sort(entryList, (o1, o2) -> {
			return o2.getValue() - o1.getValue();
		});
		
		
		for(int i=0; i<entryList.size(); i++) {
			String key =  entryList.get(i).getKey();
			
			List<int[]> mostPlayList = new ArrayList<>();
			
			for(int j=0; j<genres.length; j++) {
				if(key.equals(genres[j])) {
					mostPlayList.add(new int[] {plays[j], j});
				}
			}
			
			Collections.sort(mostPlayList, (o1, o2) -> {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o2[0] - o1[0];
				}
			});
			
			if(mostPlayList.size() == 1) {
				result.add(mostPlayList.get(0)[1]);
			} else {
				for(int j=0; j<2; j++) {
					result.add(mostPlayList.get(j)[1]);
				}
			}
		}
		
		answer = result.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}
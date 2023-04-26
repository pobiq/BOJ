import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
       HashMap<String, Integer> indexMap = new HashMap<>();
		
		for(int i=0; i<players.length; i++) {
			indexMap.put(players[i], i);
		}
		
		for(String c : callings) {
			int index = indexMap.get(c);
			String a = players[index-1];
			String b = players[index];
			
			String temp = a;
			players[index-1] = players[index];
			players[index] = temp;
			
			indexMap.put(a, indexMap.get(a)+1);
			indexMap.put(b, indexMap.get(b)-1);
		}
		
		String[] answer = players;
        
        return answer;
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    
    static List<String> list = new ArrayList<>();
	static boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        visited = new boolean[tickets.length];
		
		dfs(tickets, 0, "ICN", "ICN");
		
		Collections.sort(list);
		
		answer = list.get(0).split(" ");
        
        return answer;
    }
    
    public static void dfs(String[][] tickets, int depth, String node, String path) {
		if(depth == tickets.length) {
			list.add(path);
		}
		
		for(int i=0; i<tickets.length; i++) {
			
			if(tickets[i][0].equals(node) && visited[i] == false) {
				visited[i] = true;
				dfs(tickets, depth+1, tickets[i][1], path + " " + tickets[i][1]);
				visited[i] = false;
			}
			
		}
		
	}
    
}
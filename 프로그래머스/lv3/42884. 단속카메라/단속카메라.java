import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, (o1, o2) -> {
			return o1[1]-o2[1];
		});
		
		int[] route = routes[0];
		
		for(int i=1; i<routes.length; i++) {
			if(route[1] < routes[i][0]) {
				answer++;
				route = routes[i];
			}
			
		}
        
        return answer;
    }
}
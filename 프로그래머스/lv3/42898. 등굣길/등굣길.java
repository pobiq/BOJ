class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        long[][] map = new long[n][m];
		
		for(int i=0; i<puddles.length; i++) {
			int x = puddles[i][1]-1;
			int y = puddles[i][0]-1;
			map[x][y] = -1;
		}
		
		map[0][0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				if(i == 0 && j == 0) continue;
				
				long value = 0;
				if(i-1 >=0 && map[i-1][j] != -1) {
					value += map[i-1][j] % 1000000007;
				}
				
				if(j-1 >=0 && map[i][j-1] != -1) {
					value += map[i][j-1] % 1000000007;
				}
				
				if(map[i][j] != -1) {
					map[i][j] = value;
				}
				
			}
		}
		
		answer = (int) (map[n-1][m-1] % 1000000007);
        
        return answer;
    }
}
class Solution {
    public int[] solution(int n) {
        int length = 0;
		
		for(int i=1; i<=n; i++) {
			length += i;
		}
		
		int[] answer = new int[length];
		
		int[][] map = new int[n][n];
		
		int x = -1;
		int y = 0;
		int value = 1;
		int type = 1;
		
		while(value < length+1) {
			
			if(type == 1) {
				x += 1;
				
				if(x == n || map[x][y] != 0) {
					x -= 1;
					type = 2;
					continue;
				}
				
			} else if(type == 2) {
				y += 1;
				
				if(y == n || map[x][y] != 0) {
					y -= 1;
					type = 3;
					continue;
				}
				
			} else {
				x -= 1;
				y -= 1;
				
				if(map[x][y] != 0) {
					x += 1;
					y += 1;
					type = 1;
					continue;
				}
				
			}
			
			map[x][y] = value++;
			
		}
		
		
		int index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				answer[index++] = map[i][j];
			}
		}
        
        return answer;
    }
}
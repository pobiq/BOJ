class Solution {
    
    static int result = 0;
    
    public int solution(int n) {
        int answer = 0;
        
        int[] chess = new int[n];
		
		for(int i=0; i<n; i++) {
			chess[0] = i;
			dfs(1, chess, n);
		}
		
		answer = result;
        
        return answer;
    }
    
    static void dfs(int depth, int[] chess, int n) {
		
		if(depth == n) {
			result++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			chess[depth] = i;
			
			
			if(isExist(depth, chess, n)) {
				dfs(depth+1, chess, n);
			}
			
		}
		
	}
    
    static boolean isExist(int depth, int[] chess, int n) {
		for(int i=0; i<depth; i++) {
			if(chess[i] == chess[depth]) {
				return false;
			}
			
			if(Math.abs(i-depth) == Math.abs(chess[i] - chess[depth])) {
				return false;
			}
			
		}
		
		return true;
	}
    
}
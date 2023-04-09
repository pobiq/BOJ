class Solution {
    
    static boolean[] visited;
	static int result = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean flag = false;
		
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(target)) {
				flag = true;
			}
		}
		
		if(!flag) {
			return 0;
		}
		
		visited = new boolean[words.length];
		
		dfs(begin, target, words, 0);
		
		answer = result;
        
        return answer;
    }
    
    static void dfs(String now, String target, String[] words, int count) {
		if(now.equals(target)) {
			result = Math.min(result, count);
			return;
		}
		
		for(int i=0; i<words.length; i++) {
			int value = 0;
			char[] nowArray = now.toCharArray();
			char[] temp = words[i].toCharArray();
			
			for(int j=0; j<nowArray.length; j++) {
				if(nowArray[j] == temp[j]) {
					value++;
				}
			}
			
			if(value < words[i].length()-1)  continue;
			
			if(visited[i]) continue;
			
			visited[i] = true;
			dfs(words[i], target, words, count+1);
			visited[i] = false;
			
		}
		
	}
    
}
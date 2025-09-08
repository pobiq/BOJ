class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
		int width = 0;
		int height = 0;
		
		for(int i=0; i<sizes.length; i++) {
			int w = sizes[i][0];
			int h = sizes[i][1];
			
			if(w < h) {
				int temp = w;
				sizes[i][0] = h;
				sizes[i][1] = temp;
			}
			if(width < sizes[i][0]) {
				width = sizes[i][0];
			}
			
			if(height < sizes[i][1]) {
				height = sizes[i][1];
			}
		}
		
		answer = width*height;
        
        return answer;
    }
}
import java.util.Arrays;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int length = minerals.length;
		
		int pickaxe_count = 0;
		
		for(int i : picks) {
			pickaxe_count += i;
		}
		
		int row = Math.min(pickaxe_count, (int) Math.ceil(minerals.length/5.0));
		
		int[][] mineralCount = new int[row][3];
		int[][] fatigue = new int[row][3];
		
		for(int i=0; i<row; i++) {
			for(int j=i*5; j<i*5+5; j++) {
				String temp = minerals[j];
				
				if(temp.equals("diamond")) {
					mineralCount[i][0]++;
				} else if(temp.equals("iron")) {
					mineralCount[i][1]++;
				} else {
					mineralCount[i][2]++;
				}
				
				if(j == length-1) {
					break;
				}
			}
		}
		
		for(int i=0; i<row; i++) {
			int diamond_count = mineralCount[i][0];
			int iron_count = mineralCount[i][1];
			int stone_count = mineralCount[i][2];
			
			fatigue[i][0] = diamond_count + iron_count + stone_count;
			fatigue[i][1] = diamond_count*5 + iron_count + stone_count;
			fatigue[i][2] = diamond_count*25 + iron_count*5 + stone_count;
		}
		
		Arrays.sort(fatigue, (o1, o2) -> {
			return o2[2] - o1[2];
		});
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<3; j++) {
				if(picks[j] > 0) {
					picks[j]--;
					answer += fatigue[i][j];
					break;
				}
			}
		}
        
        return answer;
    }
}
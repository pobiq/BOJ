import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
		
		int[] ratio = new int[N+1];
		List<Double> loseRatio = new ArrayList<>();
		double totalPlayer = stages.length;
		
		for(int stage : stages) {
			ratio[stage-1]++;
		}
		
		for(int i=0; i<answer.length; i++) {
			if(totalPlayer != 0) {
				loseRatio.add(ratio[i] / totalPlayer);
				totalPlayer -= ratio[i];
			} else {
				loseRatio.add(0.0);
			}
		}
		
		List<Double> temp = new ArrayList<>(loseRatio);
		
		temp.sort(Collections.reverseOrder());

		int n = 0;
		for(Double d : temp) {
			int index = loseRatio.indexOf(d);
			answer[n] = index+1;
			n++;
			loseRatio.set(index, -1.0);
		}
        
        return answer;
    }
}
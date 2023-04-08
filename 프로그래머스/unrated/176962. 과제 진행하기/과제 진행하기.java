import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
		
		Arrays.sort(plans, (o1, o2) -> {
			String[] o1_time = o1[1].split(":");
			String[] o2_time = o2[1].split(":");
			
			int o1_minute = Integer.parseInt(o1_time[0]) * 60 + Integer.parseInt(o1_time[1]);
			int o2_minute = Integer.parseInt(o2_time[0]) * 60 + Integer.parseInt(o2_time[1]);
			
			return o1_minute - o2_minute;
		});
		
		Stack<String[]> stack = new Stack<>();
		List<String> list = new ArrayList<String>();
		
		stack.add(new String[] {plans[0][0], plans[0][1], plans[0][2]});
		
		for(int i=1; i<plans.length; i++) {
			
			String[] prev_temp = stack.peek()[1].split(":");
			String[] now_temp = plans[i][1].split(":");
			
			int prev_time = Integer.parseInt(prev_temp[0]) * 60 + Integer.parseInt(prev_temp[1]);
			int play_time = Integer.parseInt(stack.peek()[2]);
			
			int now_time = Integer.parseInt(now_temp[0]) * 60 + Integer.parseInt(now_temp[1]);
			
			if(prev_time + play_time <= now_time) {
				int playing_time = now_time - (prev_time + play_time);
				
				list.add(stack.pop()[0]);
				
				while(playing_time > 0 && !stack.isEmpty()) {
					String[] temp = stack.peek();
					int remain_time = Integer.parseInt(temp[2]);
					if(playing_time >= remain_time) {
						playing_time -= remain_time;
						list.add(stack.pop()[0]);
					} else {
						String[] temp1 = stack.pop();
						temp1[2] = Integer.toString(remain_time - playing_time);
						playing_time = 0;
						stack.add(temp1);
					}
				}
				
			} else {
				int remain_time = prev_time + play_time - now_time;
				
				String[] temp = stack.pop();
				temp[2] = Integer.toString(remain_time);
				stack.add(temp);
			}
			
			stack.add(new String[]  {plans[i][0], plans[i][1], plans[i][2]});
			
		}
		
		while(!stack.isEmpty()) {
			list.add(stack.pop()[0]);
		}
		
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}
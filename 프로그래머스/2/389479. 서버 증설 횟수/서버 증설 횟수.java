import java.util.HashMap;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int server = 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < players.length; i++) {
            if(hm.containsKey(i)) {
                server -= hm.get(i);
                hm.remove(i);
            }
            int value = players[i] / m;
            int time = i + k;
            if(server < value) {
                int plus_server = value - server;
                answer += plus_server;
                server += plus_server;
                hm.put(time, plus_server);
            }
        }
        
        return answer;
    }
}
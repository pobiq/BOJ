import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = IntStream.rangeClosed(n-1, num_list.length-1)
                .map(i -> {
                    return num_list[i];
                }).toArray();
        
        return answer;
    }
}
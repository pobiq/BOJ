import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] names) {
        int n = names.length;

        String[] answer = IntStream.rangeClosed(0, n-1)
                .filter(i -> i % 5 == 0)
                .mapToObj(i -> names[i]).toArray(String[]::new);
        
        return answer;
    }
}
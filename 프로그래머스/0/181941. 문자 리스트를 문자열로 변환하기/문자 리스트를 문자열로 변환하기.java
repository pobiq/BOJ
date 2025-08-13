import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] arr) {
        String answer = Arrays.stream(arr)
                .collect(Collectors.joining());
        return answer;
    }
}
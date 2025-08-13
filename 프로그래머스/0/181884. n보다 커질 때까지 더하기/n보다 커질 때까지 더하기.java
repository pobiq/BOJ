import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int solution(int[] numbers, int n) {
        
                AtomicInteger sum = new AtomicInteger(0);

        int answer = Arrays.stream(numbers)
                .map(sum::addAndGet)                   
                .dropWhile(total -> total <= n)          
                .findFirst()
                .orElse(0);
        return answer;
    }
}
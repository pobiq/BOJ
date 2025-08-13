import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        List<Integer> list = Arrays.stream(people)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int first = 0;
        int last = list.size() - 1;

        while(first <= last) {
            if(list.get(first) + list.get(last) <= limit) {
                first++;
                last--;
            } else {
                first++;
            }
            answer++;
        }
        
        return answer;
    }
}
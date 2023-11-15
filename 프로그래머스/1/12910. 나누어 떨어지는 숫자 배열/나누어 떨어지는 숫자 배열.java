import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        int count = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                count++;
            }
        }
        
        if (count == 0) {
            answer = new int[]{-1};
        } else {
            answer = new int[count];
        }
        
        int index = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                answer[index++] = arr[i];
            }
        }
        
        Arrays.sort(answer);
        
        
        return answer;
    }
}
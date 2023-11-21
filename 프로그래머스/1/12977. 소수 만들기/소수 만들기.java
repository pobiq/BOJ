class Solution {
    
    public static void combination(int[] input, int[] output, boolean[] visited, int depth, int start, int r) {
        if (depth == r) {
            int sum = 0;
            
            for (int n : output) {
                sum += n;
            }
            
            int count = 1;
            
            for(int i = 2; i < sum / 2; i++) {
                if (sum % i == 0) {
                    count++;
                }
            }
            
            if(count == 1) {
                answer++;
            }
            
            return;
        }
        
        for (int i = start; i<input.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = input[i];
                combination(input, output, visited, depth + 1, i, r);
                visited[i] = false;
            }
        }
    }
    
    static int answer = 0;
    
    public int solution(int[] nums) {
        
        int[] output = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        combination(nums, output, visited, 0, 0, 3);

        return answer;
    }
}
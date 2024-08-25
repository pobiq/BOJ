class Solution {
    static int result = 0;

  public int solution(int[] numbers, int target) {
    int answer = 0;

    dfs(numbers, target, 0, 0);

    answer = result;

    return answer;
  }

  public void dfs(int[] numbers, int target, int depth, int sum) {
    if(depth == numbers.length) {
      if(sum == target) {
        result++;
      }
      return;
    }
    
    dfs(numbers, target, depth+1, sum - numbers[depth]);
    dfs(numbers, target, depth+1, sum + numbers[depth]);

  }
}
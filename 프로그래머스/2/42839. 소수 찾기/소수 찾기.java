import java.util.HashSet;

class Solution {
  int length = 0;

  HashSet<Integer> hs = new HashSet<>();

  public int solution(String numbers) {

    String[] input = numbers.split("");
    boolean[] visited = new boolean[numbers.length()];
    length = numbers.length();

    for(int r = 1; r <= length; r++) {
      String[] output = new String[r];
      recursive(input, output, visited, 0, r);
    }

    return hs.size();
  }

  private void recursive(String[] input, String[] output, boolean[] visited,
      int depth, int r) {

    if(depth == r) {

      isPrime(output);

      return;
    }

    for(int i = 0; i < input.length; i++) {
      if(!visited[i]) {
        visited[i] = true;
        output[depth] = input[i];
        recursive(input, output, visited, depth+1, r);
        visited[i] = false;
      }
    }

  }

  private void isPrime(String[] output) {

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < output.length; i++) {
      sb.append(output[i]);
    }

    int result = Integer.parseInt(sb.toString());

    if(result <= 1) return;

    boolean flag = true;

    for(int i = 2; i <= Math.sqrt(result); i++) {
      if(result % i == 0) {
        flag = false;
        break;
      }
    }

    if(flag) {
      hs.add(result);
    }

  }
}
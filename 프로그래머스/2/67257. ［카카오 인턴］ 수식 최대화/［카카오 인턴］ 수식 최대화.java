import java.util.*;

class Solution {
    ArrayList<String> prioritys = new ArrayList<>();

  ArrayList<String> numbers = new ArrayList<>();
  ArrayList<String> operands = new ArrayList<>();

  ArrayList<String> copyNumbers = new ArrayList<>();
  ArrayList<String> copyOperands = new ArrayList<>();

  public long solution(String expression) {
    long answer = 0;

    String[] input = {"*", "+", "-"};
    String[] output = new String[3];
    boolean[] visited = new boolean[3];
    setPrioritys(input, output, visited, 3, 0);

    expressionSplit(expression);

    for(String priority : prioritys) {
      long result = 0;
      copyOperands = new ArrayList<>(operands);
      copyNumbers = new ArrayList<>(numbers);

      String[] priorityArray = priority.split("");
      for(String p : priorityArray) {
        int index = -1;
        while(true) {
            
            if(copyOperands.isEmpty()) break;
          index++;
          if(p.equals(copyOperands.get(index))) {
            long number1 = Long.parseLong(copyNumbers.get(index));
            long number2 = Long.parseLong(copyNumbers.get(index+1));
            long sum = 0;
            if(p.equals("*")) {
              sum = number1 * number2;
            } else if(p.equals("+")) {
              sum = number1 + number2;
            } else {
              sum = number1 - number2;
            }
            copyNumbers.remove(index);
            copyNumbers.remove(index);
            copyNumbers.add(index, Long.toString(sum));

            copyOperands.remove(index);
            index--;
          }

          if(index == copyOperands.size() - 1) {
            break;
          }
        }
      }

      result = Math.abs(Long.parseLong(copyNumbers.get(0)));

      answer = Math.max(answer, result);
    }

    return answer;
  }

  private void setPrioritys(String[] input, String[] output,
      boolean[] visited, int r, int depth) {
    if(depth == r) {
      prioritys.add(output[0] + output[1] + output[2]);
      return;
    }

    for(int i = 0; i < 3; i++) {
      if(!visited[i]) {
        visited[i] = true;
        output[depth] = input[i];
        setPrioritys(input, output, visited, r, depth + 1);
        visited[i] = false;
      }
    }
  }

  private void expressionSplit(String expression) {
    StringTokenizer st = new StringTokenizer(expression, "-*+", true);

    while(st.hasMoreTokens()) {
      String item = st.nextToken();
      if(item.equals("*") || item.equals("-") || item.equals("+")) {
        operands.add(item);
      } else {
        numbers.add(item);
      }
    }
  }
}
import java.util.*;

public class Solution {

  static char[] characters;
  static boolean[] visited;

  static int answer;

  public int solution(int n, String[] data) {
    characters = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    visited = new boolean[characters.length];
    answer = 0;
    char[] output = new char[characters.length];
    recursion(output, 0, data);
    return answer;
  }

  private void recursion(char[] output, int depth, String[] data) {
    if(depth == 8) {
      if(isPass(output, data)) {
        answer++;
      }
      return;
    }
    for(int i = 0; i < 8; i++) {
      if(!visited[i]) {
        visited[i] = true;
        output[depth] = characters[i];
        recursion(output, depth+1, data);
        visited[i] = false;
      }
    }
  }

  private boolean isPass(char[] output, String[] data) {

    StringBuilder sb = new StringBuilder();

    sb.append(output);

    String line = sb.toString();
    
    for(String s : data) {
      char[] temp = s.toCharArray();
      char firstCharacter = temp[0];
      char secondCharacter = temp[2];
      char operand = temp[3];
      int diff = Character.getNumericValue(temp[4]);

      int firstIndex = line.indexOf(firstCharacter);
      int secondIndex = line.indexOf(secondCharacter);

      int dist = Math.abs(firstIndex - secondIndex) - 1;

      if(operand == '=') {
        if(dist != diff) {
          return false;
        }
      }else if(operand == '>') {
        if(dist <= diff) {
          return false;
        }
      } else {
        if(dist >= diff) {
          return false;
        }
      }
    }
    return true;
  }
}
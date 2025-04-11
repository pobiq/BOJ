import java.util.*;

public class Solution {

  static ArrayList<String> dictionary = new ArrayList<>();
  static String[] array = {"A", "E", "I", "O", "U"};

  public int solution(String word) {
    int answer = 0;

    dfs(0, "");

    answer = dictionary.indexOf(word);

    return answer;
  }

  private void dfs(int depth, String str) {
    dictionary.add(str);

    if(depth == 5) {
      return;
    }

    for(int i = 0; i < 5; i++) {
      dfs(depth + 1, str + array[i]);
    }
  }

}
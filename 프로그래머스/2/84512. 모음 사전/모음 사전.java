import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
  String[] array = {"A", "E", "I", "O", "U"};

  public int solution(String word) {
    int answer = 0;

    recursion("");

    answer = dictionary.indexOf(word);

    return answer;
  }

  private void recursion(String s) {
    dictionary.add(s);

    if(s.length() == 5) {
      return;
    }

    for(int i = 0; i < 5; i++) {
      recursion(s + array[i]);
    }
  }
}
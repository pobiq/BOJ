import java.util.*;

class Solution {
  public boolean solution(String[] phone_book) {
    int n = phone_book.length;

    HashMap<String, Integer> hm = new HashMap<>();

    for(int i = 0; i < n; i++) {
      hm.put(phone_book[i], i);
    }

    for(int i = 0; i < n; i++) {
      for(int j = 0; j < phone_book[i].length(); j++) {
        if(hm.containsKey(phone_book[i].substring(0, j))) {
          return false;
        }
      }
    }

    return true;
  }
}
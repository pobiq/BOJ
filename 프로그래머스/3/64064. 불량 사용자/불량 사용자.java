import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {


  public int solution(String[] user_id, String[] banned_id) {

    String[][] bans = Arrays.stream(banned_id)
        .map(banned -> banned.replace('*', '.'))
        .map(banned -> Arrays.stream(user_id)
            .filter(id -> id.matches(banned))
            .toArray(String[]::new))
        .toArray(String[][]::new);

    Set<Set<String>> banSet = new HashSet<>();
    recursive(0, new HashSet<>(), bans, banSet);

    System.out.println(banSet);

    return banSet.size();
  }

  private void recursive(int index, Set<String> banned,
      String[][] bans, Set<Set<String>> banSet) {
    if(index == bans.length) {
      banSet.add(new HashSet<>(banned));
      return;
    }

    for(String id : bans[index]) {
      if(banned.contains(id)) continue;
      banned.add(id);
      recursive(index+1, banned, bans, banSet);
      banned.remove(id);
    }

  }


}
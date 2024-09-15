import java.util.*;

public class Solution {

  HashMap<String, ArrayList<Integer>> map;

  public int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];
    map = new HashMap<>();

    for(String s : info) {
      String[] input = s.split(" ");
      DFS(input, "", 0, 4);
    }

    for(String key : map.keySet()) {
      Collections.sort(map.get(key));
    }

    for(int i = 0; i < query.length; i++) {
      String temp = query[i].replaceAll(" and ", "");
      String[] array = temp.split(" ");
      String request = array[0];
      int moreScore = Integer.parseInt(array[1]);


      answer[i] = map.containsKey(request) ?
          binarySearch(map.get(request), moreScore) : 0;
    }

    return answer;
  }

  private int binarySearch(ArrayList<Integer> list, int moreScore) {
    int left = 0;
    int right = list.size() - 1;

    while(left <= right) {
      int mid = left + (right - left) / 2;

      if(list.get(mid) >= moreScore) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return list.size() - left;
  }

  private void DFS(String[] input, String str, int depth, int r)  {
    if(depth == r) {
      int value = Integer.parseInt(input[4]);
      if(map.containsKey(str)) {
        map.get(str).add(value);
      } else {
        ArrayList<Integer> emptyList = new ArrayList<>();
        emptyList.add(value);
        map.put(str, emptyList);
      }
      return;
    }

    DFS(input, str + input[depth], depth + 1, r);
    DFS(input, str + "-", depth + 1, r);
  }

}
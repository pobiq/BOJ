public class Solution {

  public int solution(int[] a) {
    int answer = 0;
    int n = a.length;

    int[] left = new int[n];
    int[] right = new int[n];
    int left_min = a[0];
    int right_min = a[n-1];

    for(int i = 1; i < n; i++) {
      if(left_min > a[i]) left_min = a[i];
      left[i] = left_min;
    }

    for(int i = n-2; i >= 0; i--) {
      if(right_min > a[i]) right_min = a[i];
      right[i] = right_min;
    }

    if(a.length == 1) return 1;
    answer = 2;
    for (int i = 1; i <= n-2; i++) {
      if(a[i] > left[i] && a[i] > right[i]) continue;
      answer++;
    }

    return answer;
  }

}
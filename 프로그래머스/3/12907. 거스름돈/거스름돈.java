class Solution {
  static final int mod = 1000000007;

  public int solution(int n, int[] money) {
    int answer = 0;

    int moneyLength = money.length;
    int[][] dp = new int[moneyLength + 1][n + 1];

    for(int i = 0; i <= moneyLength; i++) {
      dp[i][0] = 1;
    }

    for(int i = 1; i <= moneyLength; i++) {
      for(int j = 1; j <= n; j++) {
        if(j >= money[i-1]) {
          dp[i][j] = (dp[i-1][j] % mod + dp[i][j-money[i-1]] % mod) % mod;
        } else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    return dp[moneyLength][n];
  }
}
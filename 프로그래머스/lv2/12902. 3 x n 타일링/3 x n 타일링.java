class Solution {
    public int solution(int n) {
        int answer = 0;
        
        long[] dp = new long[5001];
	    int mod = 1000000007;
		
		dp[0] = 1;
		dp[2] = 3;
		dp[4] = 11;
		
		for(int i=6; i<5001; i+=2) {
			dp[i] = dp[i-2] * 3 % mod;
			for(int j=i-4; j >=0; j-=2) {
				dp[i] += dp[j]*2;
			}
			dp[i] = dp[i] % mod;
		}
		
		answer = (int) dp[n];
        
        return answer;
    }
}
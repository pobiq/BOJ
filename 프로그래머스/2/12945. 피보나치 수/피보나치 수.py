def solution(n):
    answer = 0
    dp = [0 for _ in range(n+1)]
    dp[1] = 1
    for i in range(2, n+1):
        dp[i] = (dp[i-1] % 1234567 + dp[i-2] % 1234567) % 1234567
    
    answer = dp[n]
    return answer
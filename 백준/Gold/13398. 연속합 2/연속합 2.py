import sys

n = int(input())
seq = list(map(int, input().split()))

dp = [[0] * n for _ in range(2)]

dp[0][0] = seq[0]

answer = seq[0]

for i in range(1, n):

    dp[0][i] = max(dp[0][i-1] + seq[i], seq[i])
    
    dp[1][i] = max(dp[0][i-1], dp[1][i-1] + seq[i])

    answer = max(answer, dp[0][i], dp[1][i])

print(answer)
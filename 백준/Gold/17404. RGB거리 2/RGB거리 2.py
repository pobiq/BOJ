n = int(input())

answer = 1000001

seq = [list(map(int, input().split())) for _ in range(n)]


for i in range(3):
    dp = [[1000001]*3 for _ in range(n)]
    dp[0][i] = seq[0][i]

    for j in range(1, n):
        dp[j][0] = min(dp[j-1][1], dp[j-1][2]) + seq[j][0]
        dp[j][1] = min(dp[j-1][2], dp[j-1][0]) + seq[j][1]
        dp[j][2] = min(dp[j-1][0], dp[j-1][1]) + seq[j][2]
    
    for j in range(3):
        if i != j:
            answer = min(answer, dp[-1][j])

print(answer)
def solution(m, n, puddles):
    answer = 0
    
    dp = [[0] * m for _ in range(n)]
    
    dp[0][0] = 1
    
    mod = 1000000007
    
    for puddle in puddles :
        x = puddle[1] - 1
        y = puddle[0] - 1
        dp[x][y] = -1
    
    for index in range(1, m):
        if dp[0][index] == -1:
            break
        
        dp[0][index] = 1
    
    for index in range(1, n):
        if dp[index][0] == -1:
            break
        dp[index][0] = 1
    
    for x in range(1, n):
        for y in range(1, m):
            if dp[x][y] == -1:
                continue
            
            if dp[x-1][y] >= 0:
                dp[x][y] = (dp[x][y] % mod + dp[x-1][y] % mod) % mod
            if dp[x][y-1] >= 0:
                dp[x][y] = (dp[x][y] % mod + dp[x][y-1] % mod) % mod
    
    answer = dp[n-1][m-1]
    
    
    return answer
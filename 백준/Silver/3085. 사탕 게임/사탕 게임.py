import sys
input = sys.stdin.readline

n = int(input())

candy = [list(input()) for _ in range(n)]

answer = 0

def count(candy):
    result = 1

    for i in range(n):
        res = 1

        for j in range(n-1):
            if candy[i][j] == candy[i][j+1]:
                res += 1
            else:
                res = 1
            
            if res > result:
                result = res
    
        res = 1

        for j in range(n-1):
            if candy[j][i] == candy[j+1][i]:
                res += 1
            else:
                res = 1
            
            if res > result:
                result = res
    
    return result


for i in range(n):
    for j in range(n):
        if j+1 < n:
            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]
            
            temp = count(candy)
            if temp > answer:
                answer = temp

            candy[i][j], candy[i][j+1] = candy[i][j+1], candy[i][j]
        if i+1 < n:
            candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j]
            
            temp = count(candy)
            if temp > answer:
                answer = temp

            candy[i][j], candy[i+1][j] = candy[i+1][j], candy[i][j]


print(answer)
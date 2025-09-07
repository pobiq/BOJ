def solution(n):
    answer = 0
    
    type = 0
    
    if n % 2 == 1:
        type = 1
    else:
        type = 2
    
    if type == 1:
        for i in range(1, n+1, 2):
            answer += i
    else:
        for i in range(0, n+1, 2):
            answer += i**2
            
    return answer
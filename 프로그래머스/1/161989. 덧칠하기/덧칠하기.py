def solution(n, m, section):
    answer = 0
    start = section[0] - 1
    
    
    for s in section:
        if start < s:
            start = s -1 + m
            answer += 1
            
        
    
    return answer
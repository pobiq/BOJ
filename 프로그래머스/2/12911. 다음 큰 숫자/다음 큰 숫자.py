def solution(n):
    answer = 0
    
    origin_one_count = format(n, 'b').count('1')
    
    while True:
        n += 1
        if origin_one_count == format(n, 'b').count('1'):
            break
        
    answer = n
    
    return answer
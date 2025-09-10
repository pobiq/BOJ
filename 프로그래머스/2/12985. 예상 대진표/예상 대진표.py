def solution(n,a,b):
    answer = 0
    width = 1
    
    while True:
        x = a-1
        y = b-1
        answer += 1
        width *= 2
        
        x = int(x/width)
        y = int(y/width)
        
        if x == y:
            break

    return answer
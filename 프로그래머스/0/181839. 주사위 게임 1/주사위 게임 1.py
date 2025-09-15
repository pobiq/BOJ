def solution(a, b):
    answer = 0
    
    bool1 = True if a % 2 == 1 else False
    bool2 = True if b % 2 == 1 else False
    
    if bool1 and bool2:
        answer = a**2 + b**2
    elif not bool1 and not bool2:
        answer = abs(a - b)
    else:
        answer = 2 * (a + b)
    

    
    return answer
def solution(a, b, c):
    answer = 0
    count = 0
    if a == b:
        count += 1
    
    if b == c:
        count += 1
        
    if a == c:
        count += 1
    
    if count == 0:
        answer = a + b + c
    elif count == 1:
        answer = (a + b + c) * (a**2 + b**2 + c**2)
    else:
        answer = (a + b + c) * (a**2 + b**2 + c**2 ) * (a**3 + b**3 + c**3 )
    
    return answer
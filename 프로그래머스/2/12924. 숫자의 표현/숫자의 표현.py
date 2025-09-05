def solution(n):
    answer = 0
    total = 0
    left = 0
    right = 0
    
    while left < n:
        if total == n:
            answer += 1
            right += 1
            total += right
        elif total < n:
            right += 1
            total += right
        else:
            left += 1
            total -= left
    
    return answer
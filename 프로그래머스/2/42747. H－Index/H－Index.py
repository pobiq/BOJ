def solution(citations):
    answer = 0
    left = 0
    right = max(citations)
    
    
    while left <= right:
        mid = int(left + (right - left) / 2)
        
        count = sum([1 for c in citations if c >= mid])
        
        if count >= mid:
            left = mid + 1
            answer = mid
        else:
            right = mid - 1
        
    return answer
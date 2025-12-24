def solution(k, tangerine):
    answer = 0
    dic = {}
    
    n = len(tangerine)
    
    for size in tangerine:
        dic[size] = dic.get(size, 0) + 1
        
    counts = sorted(dic.values(), reverse=True)
    
    total = 0
    for count in counts:
        if total >= k:
            break
        answer += 1
        total += count
    
    return answer
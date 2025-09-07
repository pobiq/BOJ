def solution(k, tangerine):
    answer = 0
    dic = {}
    for tan in tangerine:
        if tan in dic.keys():
            dic[tan] = dic[tan]+1
        else:
            dic[tan] = 1
    
    for value in sorted(dic.values(), reverse=True):
        if k > 0:
            k -= value
            answer += 1
        else:
            break
    
    
    return answer
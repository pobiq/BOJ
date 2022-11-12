def solution(before, after):
    answer = 1

    di = dict()

    for i in range(97, 123):
        di[chr(i)] = 0

    for s in set(before):
        di[s] = before.count(s)
    
    for k in set(after):
        di[k] -= after.count(k)
    
    for value in di.values():
        if value >= 1:
            answer = 0
            break
            
    return answer
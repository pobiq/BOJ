def solution(participant, completion):
    answer = ''
    dic = {}
    for key in participant:
        if key in dic:
            dic[key] += 1
        else:
            dic[key] = 1
    
    for key in completion:
        if key in dic:
            dic[key] -= 1
            if dic[key] == 0:
                del dic[key]
    
    for h in dic:
        answer = h
    
    
    return answer
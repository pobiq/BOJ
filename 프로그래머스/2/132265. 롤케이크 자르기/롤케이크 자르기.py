def solution(topping):
    answer = 0
    dic1 = {}
    dic2 = {}
    
    for top in topping:
        dic2[top] = dic2.get(top, 0) + 1
    
    for top in topping:
        if dic2[top] == 1:
            del dic2[top]
        else:
            dic2[top] = dic2[top] - 1
        
        dic1[top] = dic1.get(top, 0) + 1
        
        if len(dic1) == len(dic2):
            answer += 1
    
    return answer
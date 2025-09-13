def solution(elements):
    answer = 0
    n = len(elements)
    elements = elements * 2
    temp = set()
    
    for i in range(1, n+1):
        for j in range(n):
            temp.add(sum(elements[j:j+i]))
    
    answer = len(temp)
    
    
    return answer
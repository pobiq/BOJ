def solution(numbers):
    answer = [0] * len(numbers)
    answer[-1] = -1
    
    list1 = []
    
    for index, data in enumerate(numbers):
        if not list1:
            list1.append((index, data))
        else:
            while list1 and list1[-1][1] < data:
                i, d = list1.pop()
                answer[i] = data
                
            list1.append((index, data))
        
    
    while list1:
        i, d = list1.pop()
        answer[i] = -1       
    
    return answer
def solution(food):
    answer = ''
    
    arr = ["0"]

    for i in range(len(food)-1, 0, -1):
        value = int(food[i]/2)
        for j in range(value):
            arr.append(str(i))
            arr.insert(0, str(i))
        
        
    answer = ''.join(arr)
    
    return answer
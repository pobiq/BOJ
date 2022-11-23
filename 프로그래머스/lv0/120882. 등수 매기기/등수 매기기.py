import copy
def solution(score):
    answer = [0] * len(score)

    arr = []
    for s in score:
        arr.append(sum(s)/2)
    
    temp = copy.deepcopy(arr)
    number = 1
    
    print(temp)

    while temp:
        value = max(temp)
        count = temp.count(value)
        if count == 1:
            answer[arr.index(value)] = number
            temp.remove(value)
        else:
            for i in range(len(arr)):
                if arr[i] == value:
                    answer[i] = number
            for _ in range(count):
                temp.remove(value)
        number += count
        
    return answer
def solution(arr):
    answer = []
    
    arr.remove(min(arr))

    if not arr:
        answer.append(-1)
    else:
        answer = arr
    
    return answer
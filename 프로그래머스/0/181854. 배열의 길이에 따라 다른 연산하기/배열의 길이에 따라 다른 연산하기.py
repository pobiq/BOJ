def solution(arr, n):
    length = len(arr)
    answer = arr
    if length % 2 == 1:
        for i in range(0, length, 2):
            answer[i] += n
    else:
        for i in range(1, length, 2):
            answer[i] += n
    
    return answer
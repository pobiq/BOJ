def solution(arr):
    answer = []
    for data in arr:
        for _ in range(data):
            answer.append(data)
    return answer
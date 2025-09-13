def solution(n, left, right):
    answer = []
    for index in range(left, right+1):
        x = index // n
        y = index % n
        answer.append(max(x, y) + 1)
    
    
    return answer
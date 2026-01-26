def solution(n, left, right):
    answer = []
    
    for number in range(left, right + 1):
        row = number // n
        col = number % n
        max_index = max(row, col)
        answer.append(max_index + 1)
    
    return answer
def solution(numbers, k):
    answer = 0
    
    index = 2*(k-1) % len(numbers)

    answer = numbers[index]
    
    return answer
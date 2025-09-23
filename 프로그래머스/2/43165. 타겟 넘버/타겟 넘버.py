answer = 0
def solution(numbers, target):
    dfs(numbers, 0, 0, target, len(numbers))
    return answer

def dfs(numbers, total, depth, target, length):
    global answer
    if depth == length:
        if total == target:
            answer += 1
        return
    
    dfs(numbers, total+numbers[depth], depth + 1, target, length)
    dfs(numbers, total-numbers[depth], depth + 1, target, length)
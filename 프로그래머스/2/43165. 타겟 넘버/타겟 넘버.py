from collections import deque


def solution(numbers, target):
    answer = 0
    answer = BFS(numbers, target)
    return answer

def BFS(numbers, target):
    result = 0

    length = len(numbers)

    queue = deque()
    queue.append([numbers[0], 0])
    queue.append([-1 * numbers[0], 0])

    while queue:
        temp = queue.popleft()
        sum = temp[0]
        index = temp[1]

        if index == length-1:
            if sum == target:
                result += 1
        else:
            queue.append([sum + numbers[index+1], index+1])
            queue.append([sum + -1 * numbers[index+1], index+1])

    return result
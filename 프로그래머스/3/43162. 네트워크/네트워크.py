from collections import deque

answer = 0

def solution(n, computers):
    visited = [False] * n

    for i in range(0, n):
        if not visited[i]:
            BFS(n, computers, i, visited)

    return answer

def BFS(n, computers, index, visited):
    global answer
    queue = deque()
    queue.append(computers[index])
    visited[index] = True

    answer += 1

    while queue:
        temp = queue.popleft()
        for j in range(0, n):
            if j != index and temp[j] == 1 and visited[j] == False:
                visited[j] = True
                queue.append(computers[j])
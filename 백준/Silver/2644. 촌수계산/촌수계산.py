from collections import deque
import sys

n = int(sys.stdin.readline())
graph = [[] for _ in range(n+1)]
a, b = map(int, sys.stdin.readline().split())
m = int(sys.stdin.readline())

def bfs(number):
    queue = deque([[number, 0]])
    visited[number] = True
    while queue:
        temp = queue.popleft()
        next = temp[0]
        count = temp[1]
        if next == b:
            return count
        for i in graph[next]:
            if not visited[i]:
                visited[i] = True
                queue.append([i, count+1])
    return -1

for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [False] * (n+1)

result = bfs(a)

print(result)
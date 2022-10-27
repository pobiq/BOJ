from collections import deque


n, m = map(int, input().split())

matrix = [list(map(int, input())) for _ in range(n)]

def bfs(matrix):

    visited = [[0 for _ in range(m)] for _ in range(n)]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((0, 0))
    visited[0][0] = 1

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == 0 and matrix[nx][ny] == 1:
                visited[nx][ny] = visited[x][y] + 1
                queue.append((nx, ny))
    
    return visited[n-1][m-1]            
    

print(bfs(matrix))
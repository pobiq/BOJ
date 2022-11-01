from collections import deque

def solution(maps):
    answer = 0
    
    row = len(maps)
    col = len(maps[0])

    visited = [[-1] * col for _ in range(row)]

    visited[0][0] = 1
    

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    queue = deque()
    queue.append((0, 0))

    while queue:
        x, y = queue.popleft()


        for i in range(4):    
            xx = x + dx[i]
            yy = y + dy[i]

            if 0 <= xx < row and 0 <= yy < col and visited[xx][yy] == -1 and maps[xx][yy] == 1:
                queue.append((xx, yy))
                visited[xx][yy] = visited[x][y] + 1
    
    answer = visited[row-1][col-1]
    
    
    return answer
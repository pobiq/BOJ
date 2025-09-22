from collections import deque

def solution(maps):
    answer = 0
    
    queue = deque()
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * m for _ in range(n)]
    dist_array = [[0] * m for _ in range(n)]
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    queue.append((0, 0, 1))
    visited[0][0] = True
    
    while queue:
        x, y, dist = queue.popleft()
        
        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]
            next_dist = dist + 1
            
            if next_x < 0 or next_x >= n or next_y < 0 or next_y >= m:
                continue
            
            if visited[next_x][next_y] or maps[next_x][next_y] == 0:
                continue
            
            visited[next_x][next_y] = True
            dist_array[next_x][next_y] = next_dist
            queue.append((next_x, next_y, next_dist))
    
    if dist_array[n-1][m-1] == 0:
        answer = -1
    else:
        answer = dist_array[n-1][m-1]
    
    return answer
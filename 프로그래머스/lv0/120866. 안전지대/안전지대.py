def solution(board):
    answer = 0
    
    n = len(board)

    dx = [-1, 1, 0, 0, -1, -1, 1, 1]
    dy = [0, 0, -1, 1, -1, 1, -1, 1]
    
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                for k in range(len(dx)):
                    x = i + dx[k]
                    y = j + dy[k]

                    if 0 <= x < n and 0 <= y < n and board[x][y] != 1:
                        board[x][y] = 9
    

    for i in range(n):
        for j in range(n):
            if board[i][j] == 0:
                answer += 1
    
    return answer
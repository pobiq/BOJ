def solution(keyinput, board):
    answer = [0, 0]

    row = int(board[0]/2)
    col = int(board[1]/2)

    for s in keyinput:
        if s == "left":
            if -row < answer[0]:
                answer[0] += -1
        elif s == "right":
            if answer[0] < row:
                answer[0] += 1
        elif s == "up":
            if answer[1] < col:
                answer[1] += 1
        else:
            if -col < answer[1]:
                answer[1] += -1
                
    return answer
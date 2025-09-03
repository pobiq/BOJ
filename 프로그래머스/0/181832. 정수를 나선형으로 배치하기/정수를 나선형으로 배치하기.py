def solution(n):
    answer = [[0 for _ in range(n)] for _ in range(n)]
    num = 0
    row = 0
    col = -1
    length = n
    count = 1
    direction = 0
    
    while num < n*n:
        count += 1
        for _ in range(length):
            num += 1
            if direction == 0:
                col += 1
            elif direction == 1:
                row += 1
            elif direction == 2:
                col -= 1
            else:
                row -= 1
            answer[row][col] = num

        direction = (direction + 1) % 4

        if count % 2 == 0:
            length -= 1
    return answer
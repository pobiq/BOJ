def solution(n):
    answer = []
    arr = [[0 for _ in range(n)] for _ in range(n)]

    dx = [1, 0, -1]
    dy = [0, 1, -1]

    number = 0
    x = -1
    y = 0
    index = 0
    length = n
    count = 0

    while length > 0:
        number += 1
        x += dx[index]
        y += dy[index]

        arr[x][y] = number

        count += 1
        if count == length:
            count = 0
            length -= 1
            index = (index + 1) % 3


    for i in range(n):
        for j in range(n):
            if arr[i][j] == 0:
                break
            else:
                answer.append(arr[i][j])


    return answer
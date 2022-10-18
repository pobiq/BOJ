def solution(n):
    answer = []
    
    array = [[0]*i for i in range(1, n+1)]

    x, y = -1, 0
    value = 0

    for i in range(1, n+1):
        for j in range(n-i+1):
            value += 1
            if i % 3 == 0:
                x -= 1
                y -= 1
                array[x][y] = value
                pass
            elif i % 3 == 1:
                x += 1
                array[x][y] = value
            else:
                y += 1
                array[x][y] = value
    
    answer = [data for inner_list in array for data in inner_list]
    
    return answer
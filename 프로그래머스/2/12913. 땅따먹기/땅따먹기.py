def solution(land):
    answer = 0
    
    rows = len(land)
    cols = len(land[0])
    
    matrix = [[0] * cols for _ in range(rows)]
    
    for col in range(cols):
        matrix[0][col] = land[0][col]
    
    for row in range(1, rows):
        for col in range(cols):
            prev_max = 0
            for index in range(cols):
                if col != index:
                    prev_max = max(prev_max, matrix[row-1][index])
            matrix[row][col] = prev_max + land[row][col]
    
    answer = max(matrix[rows-1])

    return answer
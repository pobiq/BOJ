def solution(rows, columns, queries):
    answer = []
    
    matrix = [[i*columns+j+1 for j in range(columns)] for i in range(rows)]

    
    for s in queries:

        xstart = s[0]-1
        ystart = s[1]-1
        xend = s[2]-1
        yend = s[3]-1
        value = 1000000000
        
        temp = matrix[xstart][yend]
        if value > temp:
            value = temp

        for j in range(yend, ystart, -1):
            matrix[xstart][j] = matrix[xstart][j-1]
            if value > matrix[xstart][j-1]:
                value = matrix[xstart][j-1]
        
        temp1 = matrix[xend][yend]
        if value > temp1:
            value = temp1

        for i in range(xend, xstart, -1):
            if i == xstart+1:
                matrix[i][yend] = temp
            else:
                matrix[i][yend] = matrix[i-1][yend]
                if value > matrix[i-1][yend]:
                    value = matrix[i-1][yend]
        
        temp = matrix[xend][ystart]
        if value > temp:
            value = temp

        for j in range(ystart, yend):
            if j == yend-1:
                matrix[xend][j] = temp1
            else :
                matrix[xend][j] = matrix[xend][j+1]
                if value > matrix[xend][j+1]:
                    value = matrix[xend][j+1]
        
        for i in range(xstart, xend):
            if i == xend-1:
                matrix[i][ystart] = temp
            else:
                matrix[i][ystart] = matrix[i+1][ystart]
                if value > matrix[i+1][ystart]:
                    value = matrix[i+1][ystart]

        answer.append(value)
    
    return answer
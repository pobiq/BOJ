def solution(arr1, arr2):
    row = len(arr1)
    col = len(arr2[0])
    answer = [[0] * col for _ in range(row)]
    for x in range(row):
        for y in range(col):
            result = 0
            for i in range(len(arr1[x])):
                result += arr1[x][i] * arr2[i][y]
            answer[x][y] = result
    
    
    return answer
import numpy as np

def isCheck(mat, park):
    temp_park = np.array(park)

    for i in range(len(park) - mat + 1):
        for j in range(len(park[0]) - mat + 1):
            block = temp_park[i:i+mat, j:j+mat]
            if np.all(block == '-1'):
                return True

    return False

    

def solution(mats, park):
    answer = -1
    for mat in sorted(mats, reverse=True):
        if isCheck(mat, park):
            answer = mat
            break
    return answer
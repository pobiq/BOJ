def solution(X, Y):
    answer = ''
    
    a = list(X)
    b = list(Y)
    countA = [0]*10
    countB = [0]*10
    union = []

    for i in a:
        countA[int(i)] += 1
    for i in b:
        countB[int(i)] += 1
    
    for i in range(9, -1, -1):
        value = min(countA[i], countB[i])
        for j in range(value):
            union.append(i)
    
    total = sum(union)

    if union == []:
        answer = "-1"
    elif total == 0:
        answer = "0"
    else:
        answer = "".join(map(str, union))
    
    
    return answer
def solution(N, stages):
    answer = []
    clear = [0] * (N + 2)
    counts = [0] * (N + 2)
    failRateList = []
    
    for i in range(len(stages)):
        stage = stages[i]
        counts[stage] += 1
        for j in range(1, stage+1):
            clear[j] += 1
    
    for i in range(1, N+1):
        if counts[i] == 0:
            failRateList.append([i, 0])
        else:
            failRateList.append([i, counts[i] / clear[i]])
    
    failRateList.sort(key=lambda x : -x[1])
    print(failRateList)
    
    for i, data in failRateList:
        answer.append(i)
    
    return answer
import math

def solution(progresses, speeds):
    answer = []
    
    n = len(progresses)
    
    time = [0] * n

    for index, data in enumerate(progresses):
        time[index] = math.ceil((100 - data) / speeds[index])

    nowTime = time[0]
    count = 1
    for i in range(1, n):
        if nowTime >= time[i]:
            count += 1
        else:
            nowTime = time[i]
            answer.append(count)
            count = 1

    answer.append(count)
    
    return answer
def solution(k, m, score):
    answer = 0
    
    if len(score) < m:
        return 0
    
    score.sort(reverse=True)

    index = 0
    box = int(len(score) / m)

    for i in range(box):
        value = score[index:index+m]
        index += m
        answer += m*value[-1]
    
    return answer
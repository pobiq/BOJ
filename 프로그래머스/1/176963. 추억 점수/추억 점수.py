def solution(name, yearning, photo):
    answer = []
    dic_index = {}
    for name, yearn in zip(name, yearning):
        dic_index[name] = yearn
    for row in photo:
        total = 0
        for key in row:
            if key in dic_index.keys():
                total += dic_index[key]
        answer.append(total)
    
    return answer
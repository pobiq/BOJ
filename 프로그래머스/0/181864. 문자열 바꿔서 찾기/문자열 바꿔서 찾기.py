def solution(myString, pat):
    temp = ''
    for text in myString:
        if text == 'A':
            temp += 'B'
        else:
            temp += 'A'
    
    answer = 0
    if pat in temp:
        answer = 1
    
    return answer
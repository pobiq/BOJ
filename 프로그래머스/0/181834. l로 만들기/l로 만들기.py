def solution(myString):
    answer = ''
    for alpha in myString:
        if ord(alpha) < ord('l'):
            answer += 'l'
        else:
            answer += alpha
    return answer
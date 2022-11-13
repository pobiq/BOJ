def solution(s):
    answer = ''
    
    for i in range(97, 123):
        text = chr(i)
        if s.count(text) == 1:
            answer += text
    
    return answer
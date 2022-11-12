def solution(my_string):
    answer = ''
    
    for s in my_string:
        if answer.find(s) == -1:
            answer += s
    
    return answer
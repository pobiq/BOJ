def solution(my_string):
    answer = 0
    
    for s in my_string:
        if s.isnumeric():
            answer += int(s)
    
    return answer
import re

def solution(my_string):
    answer = 0
    
    li = re.split(r'[a-zA-Z]', my_string)

    for s in li:
        if s:
            answer += int(s)
    
    return answer
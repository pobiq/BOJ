def solution(my_strings, parts):
    answer = ''
    for i, part in enumerate(parts):
        answer +=  str(my_strings[i][part[0] : part[1]+1])
    
    return answer
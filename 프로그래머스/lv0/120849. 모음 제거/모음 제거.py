def solution(my_string):
    answer = ''
    
    arr = ['a', 'e', 'i', 'o', 'u']

    for s in my_string:
        if s not in arr:
            answer += s
    
    return answer
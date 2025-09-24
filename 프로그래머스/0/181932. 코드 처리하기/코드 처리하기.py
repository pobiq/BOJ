def solution(code):
    answer = ''
    mode = 0
    for index, data in enumerate(code):
        if mode == 0:
            if data == "1":
                mode = 1
            else:
                if index % 2 == 0:
                    answer += data
        else:
            if data == "1":
                mode = 0
            else:
                if index % 2 == 1:
                    answer += data
    
    if not answer:
        answer = "EMPTY"
    
    return answer
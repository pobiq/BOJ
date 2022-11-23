def solution(polynomial):
    answer = ''
    
    temp = [0, 0]
    arr = polynomial.split(" + ")
    
    for s in arr:
        if s.isdigit():
            temp[1] += int(s)
        else:
            text = s.replace("x", "")
            if text == "":
                temp[0] += 1
            else:
                temp[0] += int(text)

    if temp[0] > 0:
        if temp[0] == 1:
            answer += "x"
        else:
            answer += str(temp[0]) + "x"
    
    if temp[0] > 0:
        if temp[1] > 0:
            answer += " + " + str(temp[1])
    else:
        answer += str(temp[1])
    
    return answer
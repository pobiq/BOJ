def solution(n, control):
    answer = n
    for text in control:
        if text == "w":
            answer += 1
        elif text == "s":
            answer -= 1
        elif text == "d":
            answer += 10
        else:
            answer -= 10
    return answer
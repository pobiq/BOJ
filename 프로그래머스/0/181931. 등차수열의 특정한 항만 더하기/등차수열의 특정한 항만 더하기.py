def solution(a, d, included):
    answer = 0
    num = a - d
    for flag in included:
        num += d
        if flag:
            answer += num
    return answer
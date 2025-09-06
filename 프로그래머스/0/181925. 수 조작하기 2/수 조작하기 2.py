def solution(numLog):
    answer = ''
    result = numLog[0]
    for num in numLog[1:]:
        if result + 1 == num:
            answer += "w"
            result += 1
        elif result - 1 == num:
            answer += "s"
            result -= 1
        elif result + 10 == num:
            answer += "d"
            result += 10
        else:
            answer += "a"
            result -= 10
    return answer
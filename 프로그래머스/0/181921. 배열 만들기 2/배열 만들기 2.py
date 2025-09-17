def solution(l, r):
    answer = []
    for number in range(l, r+1):
        five_count = str(number).count('5')
        one_count = str(number).count('0')
        if len(str(number)) == five_count + one_count:
            answer.append(number)
    
    if not answer:
        answer = [-1]
    return answer
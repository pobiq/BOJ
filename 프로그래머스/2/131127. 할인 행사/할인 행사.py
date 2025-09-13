def solution(want, number, discount):
    answer = 0
    length = sum(number)
    want_list = []
    for i, v in enumerate(want):
        for _ in range(number[i]):
            want_list.append(v)
    
    want_list.sort()
    
    for i in range(len(discount)+1-length):
        temp = discount[i:i+length]
        temp.sort()
        if temp == want_list:
            answer += 1
    
    return answer
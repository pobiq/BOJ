def solution(number, limit, power):
    answer = 0
    
    count = [0] * number
    
    for i in range(1, number+1):
        for j in range(1, int(i**(1/2))+1):
            if i % j == 0:
                count[i-1] += 1
                if j != i//j:
                    count[i-1] += 1

    for c in count:
        if c <= limit:
            answer += c
        else:
            answer += power
    
    return answer
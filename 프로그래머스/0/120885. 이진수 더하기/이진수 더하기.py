def solution(bin1, bin2):
    answer = ''
    result = 0
    for i,num in enumerate(bin1[::-1]) :
        if num == '1' :
            result += 2**i
    for i,num in enumerate(bin2[::-1]) :
        if num == '1' :
            result += 2**i
    
    if result == 0:   # <= 이거 빠져 있었음
        answer = '0'
    else:
        while result != 0 :
            answer = str(result % 2) + answer
            result //= 2
    
    return answer
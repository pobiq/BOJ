def solution(bin1, bin2):
    answer = ''
    
    result = int(bin1, 2) + int(bin2, 2)

    answer = format(result, 'b')
    
    return answer
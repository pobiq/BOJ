def solution(num_list):
    answer = 0
    
    num1 = 1
    
    for num in num_list:
        num1 *= num
    
    num2 = sum(num_list) ** 2
    
    if num1 < num2:
        answer = 1
    else :
        answer = 0
    
    
    return answer
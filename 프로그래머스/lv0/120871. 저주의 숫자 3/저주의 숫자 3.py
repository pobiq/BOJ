def solution(n):
    answer = 0
    
    for i in range(1, n+1):
        answer += 1

        while True:
            if answer % 3 == 0:
                answer += 1

            if str(answer).count("3") > 0:
                answer += 1
            
            if answer % 3 != 0 and str(answer).count("3") == 0:
                break
    
    return answer
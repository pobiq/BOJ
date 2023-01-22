def solution(s):
    answer = [-1]
    
    for i in range(len(s)):
        distance = i+1
        flag = False
        for j in range(0, i):
            if s[i] == s[j]:
                distance = min(distance, i-j)
                flag = True
            
            if j == i-1:
                if flag:
                    answer.append(distance)
                else:
                    answer.append(-1)
    return answer
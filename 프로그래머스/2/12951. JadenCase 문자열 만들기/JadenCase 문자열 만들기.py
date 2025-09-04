def solution(s):
    answer = ''
    
    s_array = s.split(" ")
    for i in range(len(s_array)):
        for j in range(len(s_array[i])):
            if j == 0:
                if s_array[i][j].isalpha():
                    answer += s_array[i][j].upper()
                else:
                    answer += s_array[i][j]
            else:
                if s_array[i][j].isupper():
                    answer += s_array[i][j].lower()
                else:
                    answer += s_array[i][j]
        if i != len(s_array)-1:
            answer += ' '
    
    return answer
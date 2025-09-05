def solution(s):
    answer = 0
    
    stack = []
    
    for data in s:
        if stack:
            if stack[-1] == data:
                stack.pop()
            else:
                stack.append(data)
        else:
            stack.append(data)
        
    
    if not stack:
        answer = 1
    
    return answer
def solution(s):
    answer = 0
    length = len(s)
    
    
    for _ in range(length):
        stack = []
        for data in s:
            if stack:
                if data == ']' and stack[-1] == '[':
                    stack.pop()
                elif data == ')' and stack[-1] == '(':
                    stack.pop()
                elif data == '}' and stack[-1] == '{':
                    stack.pop()
                else:
                    stack.append(data)
            else:
                stack.append(data)
        
        if not stack:
            answer += 1
        
        s = s[1:] + s[0]
    
    return answer
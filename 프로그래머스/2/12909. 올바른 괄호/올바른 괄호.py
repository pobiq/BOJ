def solution(s):
    answer = False
    
    stack = []

    for data in s:
        if data == '(':
            stack.append(data)
        else:
            if stack:
                if stack[-1] == '(':
                    stack.pop()
                else:
                    stack.append(data)
            else:
                stack.append(data)

    if not stack:
        answer = True

    return answer
from itertools import permutations, combinations

def solution(number, k):
    answer = ''
    
    stack = []

    for num in number:
        if not stack:
            stack.append(num)
            continue
        
        if k > 0:
            while stack[-1] < num:
                stack.pop()
                k -= 1
                if not stack or k <= 0:
                    break
        
        stack.append(num)

    if k > 0:
        answer = ''.join(stack[:-k])
    else:
        answer = ''.join(stack)
    
    return answer
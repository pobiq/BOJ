from collections import deque

def solution(order):
    
    answer = 0
    
    start = order[0]
    
    n = len(order)
    
    sub_container = deque(range(0, start + 1))
    container = deque(range(start+1, n+1))
    
    for data in order:
        
        while container and container[0] <= data:
            sub_container.append(container.popleft())
        
        if container and data == container[0]:
            answer += 1
            container.popleft()
        elif sub_container and data == sub_container[-1]:
            answer += 1
            sub_container.pop()
        else:
            break
    
    return answer
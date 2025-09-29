from collections import deque

def solution(order):
    
    answer = 0
    sub_container = []
    
    start = order[0]
    
    n = len(order)
    
    sub_container = deque(range(0, start+1))
    container = deque(range(start+1, n+1))
    
    for data in order:
        
        while container and container[0] <= data:
            sub_container.append(container.popleft())
        
        if sub_container and sub_container[-1] == data:
            sub_container.pop()
            answer += 1
        elif container and container[0] == data:
            container.popleft()
            answer += 1
        else:
            break
    
    
    return answer
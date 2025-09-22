def solution(priorities, location):
    answer = 0
    queue = []
    prior_array = [0] * 10
    
    for index, value in enumerate(priorities):
        queue.append((index, value))
        prior_array[value] += 1
    
    
    count = 0
    while queue:
        i, v = queue.pop(0)
        max_priority = True
        for index, value in queue:
            if value > v:
                max_priority = False
        
        if max_priority:
            count += 1
            if i == location:
                answer = count
                break
        else:
            queue.append((i, v))
        
    return answer
def solution(participant, completion):
    answer = ''
    
    hashmap = {}

    for key in participant:
        if key in hashmap:
            hashmap[key] += 1
        else:
            hashmap[key] = 1
    
    for key in completion:
        hashmap[key] -= 1

    for key in hashmap:
        if hashmap[key] == 1:
            answer = key
    
    return answer
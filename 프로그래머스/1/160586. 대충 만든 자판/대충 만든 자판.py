def solution(keymap, targets):
    answer = []
    
    count = [10000] * 26
    
    for key in keymap:
        for index, alpha in enumerate(key):
            count[ord(alpha)-65] = min(count[ord(alpha)-65], index+1)
    
    for target in targets:
        total = 0
        for alpha in target:
            total += count[ord(alpha)-65]
        if total >= 10000:
            answer.append(-1)
        else:
            answer.append(total)
            
    
    return answer
def solution(s):
    answer = []
    trans = 0
    remove_zero = 0
    while True:
        origin_len = len(s)
        s = s.replace("0", "")
        remove_zero += origin_len - len(s)
        s = format(len(s), 'b')
        trans += 1
        if s == '1':
            break
    
    answer = [trans, remove_zero]
    
    return answer
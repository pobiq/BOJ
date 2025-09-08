def solution(n, words):
    answer = []
    turn = 0
    index = 0
    arr = [words[0][0]]
    
    for i, data in enumerate(words):
        if data in arr or arr[-1][-1] != data[0]:
            turn = i // n + 1
            index = (i % n) + 1
            break
        else:
            arr.append(data)
        
    
    answer = [index, turn]

    return answer
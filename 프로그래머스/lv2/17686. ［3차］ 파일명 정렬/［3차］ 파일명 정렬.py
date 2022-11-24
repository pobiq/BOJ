import re

def solution(files):
    answer = []
    
    arr = []
    
    for i in files:
        p = re.compile('[0-9]+')
        result = p.search(i).span()
        head = i[0 : result[0]]
        number = i[result[0] : result[1]]
        tail = i[result[1] : ]
        arr.append((head, number, tail))

    arr.sort(key=lambda x: [x[0].lower(), int(x[1])])

    for s in arr:
        answer.append(''.join(s))
    
    return answer
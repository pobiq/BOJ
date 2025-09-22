import re

def solution(s):
    answer = []
    temp = s.split('},')
    array = []
    for data in temp:
        data = re.sub(r'[{}]', '', data)
        array.append(data)
        
    array = sorted(array, key=lambda x: len(x))
    
    list1 = []
    
    for str1 in array:
        temp = str1.split(',')
        for t in temp:
            list1.append(int(t))
    
    answer = list(dict.fromkeys(list1))
    
    return answer
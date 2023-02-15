from itertools import combinations

def solution(orders, course):
    answer = []
    
    for number in course:

        dicts = dict()

        for s in orders:
            temp = list(s)
            for i in combinations(temp, number):
                if ''.join(sorted(i)) in dicts:
                    dicts[''.join(sorted(i))] += 1
                else:
                    dicts[''.join(sorted(i))] = 1
        
        sorted_dicts = dict(sorted(dicts.items(), key = lambda x : x[1], reverse = True))

        for index, (key, value) in enumerate(sorted_dicts.items()):
            if index == 0:
                maxValue = value
            if maxValue == value and maxValue > 1:
                answer.append(key)
            else:
                break
    
    answer = sorted(answer)
                
    return answer
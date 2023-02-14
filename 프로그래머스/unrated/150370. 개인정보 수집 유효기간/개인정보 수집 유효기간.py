def solution(today, terms, privacies):
    answer = []
    
    sDate = list(map(int,today.split(".")))
    sDay = sDate[0] * 336 + sDate[1] * 28 + sDate[2]

    type = [0] * 26
    
    for i in range(len(terms)):
        temp = terms[i].split(" ")
        type[ord(temp[0])-65] = int(temp[1])
    
    for i in range(len(privacies)):
        privacy = privacies[i].split(" ")
        dDate = list(map(int, privacy[0].split(".")))
        index = ord(privacy[1])-65

        addMonth = type[index]
        
        dDay = dDate[0] * 336 + dDate[1] * 28 + dDate[2] + addMonth * 28 - 1

        if sDay > dDay:
            answer.append(i+1)
    
    return answer
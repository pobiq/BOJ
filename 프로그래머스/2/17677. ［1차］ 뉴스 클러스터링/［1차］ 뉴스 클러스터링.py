def solution(str1, str2):
    answer = 0
    str1 = str1.lower()
    str2 = str2.lower()
    list1 = []
    inter_list = []
    union_list = []
    
    for i in range(len(str1)-1):
        text = str1[i:i+2]
        if text.isalpha():
            list1.append(text)
    
    union_list = list1.copy()
    
    for i in range(len(str2)-1):
        text = str2[i:i+2]
        if text.isalpha():
            if text in list1:
                list1.remove(text)
                inter_list.append(text)
            else:
                union_list.append(text)
    
    if union_list:
        answer = len(inter_list) / len(union_list) * 65536
        answer = int(answer)
    else :
        answer = 65536

    return answer
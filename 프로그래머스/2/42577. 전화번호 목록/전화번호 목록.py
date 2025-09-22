def solution(phone_book):
    answer = True
    
    phone_book.sort(key = lambda x : len(x))
    
    dic = {}
    
    for phone in phone_book:
        for index in range(len(phone) + 1):
            if dic.get(phone[:index]) == 1:
                return False
        dic[phone] = 1
    
    return answer
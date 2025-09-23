value = -1

def solution(word):
    answer = 0
    dic = {}
    word_list = ['A', 'E', 'I', 'O', 'U']
    recursive("", dic, word_list)
    
    answer = dic[word]
    
    return answer

def recursive(text, dic, word_list):
    global value
    if len(text) >= 6:
        return
    
    value += 1
    dic[text] = value
    
    for w in word_list:
        recursive(text + w, dic, word_list)
    
import re

def solution(n, k):
    answer = 0
    
    num = convert(n, k)
    num = re.sub('0+', ',', num)
    list1 = num.split(',')
    
    for data in list1:
        if data and isPrime(int(data)):
            answer += 1
    
    return answer


def convert(n, base):
    T = "0123456789ABCDEF"
    q, r = divmod(n, base)
    
    return convert(q, base) + T[r] if q else T[r]

def isPrime(number):
    if number < 2:
        return False
    if number == 2:
        return True
    if number % 2 == 0:
        return False
    
    for i in range(3, int(number**0.5) + 1, 2):
        if number % i == 0:
            return False
    
    return True

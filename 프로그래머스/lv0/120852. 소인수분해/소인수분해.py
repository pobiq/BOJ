import math

def solution(n):
    answer = []
    
    def is_prime_number(number):
        for i in range(2, int(math.sqrt(number)) + 1):
            if number % i == 0:
                return False
        return True

    while n > 1:
        for i in range(2, n+1):
            if n % i == 0 and is_prime_number(i):
                n = int(n / i)
                if i not in answer:
                    answer.append(i)
    
    return answer
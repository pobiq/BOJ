def solution(arr):
    answer = 0
    
    temp = arr[0]
    
    for value in arr[1:]:
        temp = lcm(temp, value)
    
    answer = temp
    
    return answer

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def lcm(a, b):
    return (a * b) // gcd(a, b)

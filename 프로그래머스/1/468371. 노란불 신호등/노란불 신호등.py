import math

def solution(signals):
    answer = 0
    
    cycles = []
    for signal in signals:
        cycles.append(sum(signal))
    
    # 최소 공배수 계산
    lcm = 1
    for num in cycles:
        lcm = lcm * num // math.gcd(lcm, num)
    
    
    for t in range(0, lcm):
        flag = True
        
        for g, y, r in signals:
            cycle = g + y + r
            pos = t % cycle
            
            if not (g <= pos <= g + y - 1):
                flag = False
                break
        
        if flag:
            return t + 1
        
    return -1
    
    
    return answer
T = int(input())

for i in range(T):
    s, p = input().split()
    
    print(len(s) - s.count(p)*(len(p)-1))
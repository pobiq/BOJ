import sys
input = sys.stdin.readline
from itertools import combinations, permutations


N, K = map(int, input().split())

words = [0] * N
result = 0

for i in range(N):
    temp = input().rstrip()

    for t in temp:
        words[i] |= (1 << (ord(t) - ord('a')))

if K >= 5:
    candidiate = ['b','d','e','f','g','h','j','k','l','m','o','p','q','r','s','u','v','w','x','y','z']
    need = ['a','c','t','i','n']
    
    for i in list(combinations(candidiate, K-5)):
        answer = 0
        value = 0

        for j in need:
            value |= (1 << (ord(j) - ord('a')))
        for j in i:
            value |= (1 << (ord(j) - ord('a')))

        for j in words:
            if value & j == j:
                answer += 1
        
        if result < answer:
            result = answer

print(result)
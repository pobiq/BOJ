arr1 = []
arr2 = []
score = 0
answer = []
for i in range(8):
    n = int(input())
    arr1.append(n)
    arr2.append(n)

for i in range(5):
    n1 = max(arr2)
    
    score += n1
    
    answer.append(arr1.index(n1) + 1)
    arr2.remove(n1)

print(score)
print(*sorted(answer))
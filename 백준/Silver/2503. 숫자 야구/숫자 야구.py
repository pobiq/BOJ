from itertools import permutations

N = int(input())

items = [1,2,3,4,5,6,7,8,9]
arr = list(permutations(items, 3))

for i in range(N):
    number, s, b = map(int, input().split())
    number = list(str(number))
    removed_cnt = 0

    for i in range(len(arr)):
        s_cnt = b_cnt = 0
        i -=  removed_cnt

        for j in range(3):
            number[j] = int(number[j])

            if number[j] in arr[i]:
                if j == arr[i].index(number[j]):
                    s_cnt += 1
                else:
                    b_cnt += 1
        
        if s_cnt != s or b_cnt != b:
            arr.remove(arr[i])
            removed_cnt += 1

print(len(arr))
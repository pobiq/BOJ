N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

A.sort()

for number in B:
    start, end = 0, N-1
    exist = False

    while start <= end:
        mid = (start + end) // 2
        if number == A[mid]:
            exist = True
            print(1)
            break
        elif number > A[mid]:
            start = mid + 1
        else:
            end = mid - 1
    
    if not exist:
        print(0)



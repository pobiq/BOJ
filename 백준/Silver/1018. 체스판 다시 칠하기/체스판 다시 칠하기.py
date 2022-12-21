N, M = map(int, input().split())

arr = []

for i in range(N):
    arr.append(list(input()))

result = 100

for i in range(0, N-7):
    for j in range(0, M-7):
        
        count1 = 0
        count2 = 0
        
        for k in range(i, i+8):
            for l in range(j, j+8):

                if (k-i) % 2 == 0:
                    if (l-j) % 2 == 0:
                        if arr[k][l] != "W":
                            count1 += 1
                    else:
                        if arr[k][l] != "B":
                            count1 += 1
                else:
                    if (l-j) % 2 == 0:
                        if arr[k][l] != "B":
                            count1 += 1
                    else:
                        if arr[k][l] != "W":
                            count1 += 1
                
                if (k-i) % 2 == 0:
                    if (l-j) % 2 == 0:
                        if arr[k][l] != "B":
                            count2 += 1
                    else:
                        if arr[k][l] != "W":
                            count2 += 1
                else:
                    if (l-j) % 2 == 0:
                        if arr[k][l] != "W":
                            count2 += 1
                    else:
                        if arr[k][l] != "B":
                            count2 += 1

        if result > count1:
            result = count1

        if result > count2:
            result = count2

print(result)


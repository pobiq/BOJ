def solution(lines):
    answer = 0
    
    arr = []

    for i in lines:
        temp = set()
        for j in range(i[0], i[1]):
            temp.add((j, j+1))
        
        arr.append(temp)

    x = arr[0].intersection(arr[1])
    y = arr[0].intersection(arr[2])
    z = arr[1].intersection(arr[2])

    li = list((x.union(y)).union(z))

    answer = len(li)
    
    return answer
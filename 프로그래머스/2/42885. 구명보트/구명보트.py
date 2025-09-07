def solution(people, limit):
    answer = 1
    people.sort()
    left = 0
    right = len(people) - 1
    weight = 0
    count = 0
    while left <= right:
        if weight + people[right] <= limit and count < 2:
            weight += people[right]
            count += 1
            right -= 1
        elif weight + people[left] <= limit and count < 2:
            weight += people[left]
            count += 1
            left += 1
        else:
            weight = 0
            count = 0
            answer += 1

        
    return answer
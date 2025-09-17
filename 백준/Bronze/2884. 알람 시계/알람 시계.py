a, b = map(int, input().split())
totalMinute = a * 60 + b
totalMinute -= 45
if totalMinute < 0:
    totalMinute += 24 * 60
answer_hour = totalMinute // 60
answer_minute = totalMinute % 60
print(answer_hour, answer_minute)
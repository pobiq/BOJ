def solution(schedules, timelogs, startday):
    answer = 0
    
    n = len(schedules)
    
    answer = n
    
    for row in range(n):
        start_work_time = schedules[row] // 100 * 60 + schedules[row] % 100 + 10
        
        for col in range(startday, startday + 7):
            if col % 7 not in (0, 6):
                index = col - startday
                temp_start_work_time = timelogs[row][index] // 100 * 60 + timelogs[row][index] % 100
                if temp_start_work_time > start_work_time:
                    answer-= 1
                    break
        
    return answer
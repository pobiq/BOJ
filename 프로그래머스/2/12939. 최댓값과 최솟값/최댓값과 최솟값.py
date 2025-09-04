def solution(s):
    answer = ''
    max_number = float("-inf")
    min_number = float("inf")
    
    for num in s.split(" "):
        int_num = int(num)
        max_number = max(max_number, int_num)
        min_number = min(min_number, int_num)

    answer = str(min_number) + " " + str(max_number)
    
    return answer
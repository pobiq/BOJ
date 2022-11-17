def solution(numbers):
    answer = 0
    
    array = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]

    for i in range(len(array)):
        numbers = numbers.replace(array[i], str(i))
    
    answer = int(numbers)
    
    
    return answer
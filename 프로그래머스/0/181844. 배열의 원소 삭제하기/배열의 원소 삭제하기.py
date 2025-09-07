def solution(arr, delete_list):
    answer = arr
    for data in delete_list:
        if data in answer:
            answer.remove(data)
    return answer
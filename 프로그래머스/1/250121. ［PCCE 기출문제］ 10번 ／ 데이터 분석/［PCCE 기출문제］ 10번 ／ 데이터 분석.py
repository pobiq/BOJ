def solution(data, ext, val_ext, sort_by):
    answer = []
    
    ext_index = get_index(ext)
    sort_index = get_index(sort_by)
    
    for d in data:
        if d[ext_index] < val_ext:
            answer.append(d)
    
    answer.sort(key=lambda x : x[sort_index])
    
    return answer

def get_index(field_name):
    field_to_idx = {"code" : 0, "date" : 1, "maximum" : 2, "remain" : 3}
    return field_to_idx[field_name]
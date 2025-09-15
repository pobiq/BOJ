def solution(cacheSize, cities):
    answer = 0
    
    cache_list = []

    if cacheSize == 0:
        return len(cities) * 5
    
    for city in cities:
        city = city.lower()
        if len(cache_list) >= cacheSize:
            if city in cache_list:
                cache_list.remove(city)
                answer += 1
            else:
                del cache_list[0]
                answer += 5
            cache_list.append(city)
        else:
            if city in cache_list:
                cache_list.remove(city)
                answer += 1
            else:
                answer += 5
            cache_list.append(city)
    
    return answer
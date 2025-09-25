from heapq import heappush, heappop, heapify

def solution(scoville, K):
    answer = 0
    heap = []
    
    for sc in scoville:
        heappush(heap, sc)
     
    while True:
        if len(heap) == 1:
            break
        a = heappop(heap)
        if a >= K:
            break
        b = heappop(heap)
        heappush(heap, (a + b*2))
        answer += 1
    
    result = heappop(heap)
    if result < K:
        answer = -1
    
    return answer
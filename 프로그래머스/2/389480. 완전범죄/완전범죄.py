def solution(info, n, m):
    answer = float("inf")
    visited = set()

    def dfs(info, n, m, depth, a_sum, b_sum):
        nonlocal answer
        if a_sum >= n or b_sum >= m:
            return

        if (depth, a_sum, b_sum) in visited:
            return
        
        if depth == len(info):
            answer = min(answer, a_sum)
            return

        visited.add((depth, a_sum, b_sum))
    
        dfs(info, n, m, depth+1, a_sum + info[depth][0], b_sum)
        dfs(info, n, m, depth+1, a_sum, b_sum + info[depth][1])
    
    dfs(info, n, m, 0, 0, 0)
    answer = -1 if answer == float("inf") else answer
    return answer
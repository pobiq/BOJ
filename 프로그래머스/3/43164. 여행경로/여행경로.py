answer = []
def solution(tickets):

    visited = [False] * len(tickets)

    DFS(tickets, ["ICN"],  0, visited)

    return answer

def DFS(tickets, arr, depth, visited):
    global answer
    if depth == len(tickets):
        if not answer or arr < answer:
            answer = arr[:]
        return

    start = arr[depth]

    for j in range(len(tickets)):
        temp = tickets[j]
        if start == temp[0] and not visited[j]:
            visited[j] = True
            DFS(tickets, arr + [temp[1]], depth + 1, visited)
            visited[j] = False
import numpy as np

def solution(A, B):
    answer = 0
    A.sort()
    B.sort(reverse=True)

    a = np.array(A)
    b = np.array(B)

    answer = sum(a * b for a, b in zip(A, B))

    return answer
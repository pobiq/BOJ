class Solution {
    fun solution(M: Int, N: Int): Int {
        var answer: Int = 0
        
        answer = (M - 1) + M * (N - 1)
        
        return answer
    }
}
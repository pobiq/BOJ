class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        
        var s = n.toString()
        
        val splitData = s.chunked(1)
        
        for(sd in splitData) {
            answer += sd.toInt()
        }
        
        return answer
    }
}
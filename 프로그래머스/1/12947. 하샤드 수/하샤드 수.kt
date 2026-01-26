class Solution {
    fun solution(x: Int): Boolean {
        var answer = false
        
        var digit_sum = 0
        
        val splitData = x.toString().chunked(1)
        
        for(sd in splitData) {
            digit_sum += sd.toInt()
        }
        
        if(x % digit_sum == 0) {
            answer = true
        }
         
        return answer
    }
}
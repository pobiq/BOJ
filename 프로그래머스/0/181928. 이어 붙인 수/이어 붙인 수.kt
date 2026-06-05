class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var oddNumber : String = ""
        var evenNumber : String = ""
        for ((index, data) in num_list.withIndex()) {
            if(data % 2 == 0) {
                evenNumber += data.toString()
            } else {
                oddNumber += data.toString()
            }
        }
        
        answer = oddNumber.toInt() + evenNumber.toInt()
        
        return answer
    }
}
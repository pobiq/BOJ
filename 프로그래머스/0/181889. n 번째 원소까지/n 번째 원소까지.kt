class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        for((index, num) in num_list.withIndex()) {
            if(index < n) {
                answer = answer.plus(num)
            }
        }
        
        return answer
    }
}
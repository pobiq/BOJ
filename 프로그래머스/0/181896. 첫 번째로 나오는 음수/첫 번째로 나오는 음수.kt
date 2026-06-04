class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        for ((index, item) in num_list.withIndex()) {
            if(num_list[index] < 0) {
                return index
            }
        }
        return -1
    }
}
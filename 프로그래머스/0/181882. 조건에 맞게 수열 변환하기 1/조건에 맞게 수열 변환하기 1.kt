class Solution {
    fun solution(arr: IntArray): MutableList<Int> {
        var answer = mutableListOf<Int>()
        for((index, data) in arr.withIndex()) {
            if(data >= 50 && data % 2 == 0) {
                answer.add(data / 2)
            } else if(data < 50 && data % 2 == 1) {
                answer.add(data * 2)
            } else {
                answer.add(data)
            }
        }
        return answer
    }
}
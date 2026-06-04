class Solution {
    fun solution(strArr: Array<String>): MutableList<String> {
        var answer: MutableList<String> = mutableListOf<String>()
        
        for((index, data) in strArr.withIndex()) {
            if(index % 2 == 0) {
                answer.add(data.lowercase())
            } else {
                answer.add(data.uppercase())
            }
        }
        return answer
    }
}
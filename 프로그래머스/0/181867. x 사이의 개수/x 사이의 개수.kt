class Solution {
    fun solution(myString: String): MutableList<Int> {
        var answer: MutableList<Int> = mutableListOf()
        var my_split = myString.split("x")
        for((index, data) in my_split.withIndex()) {
            answer.add(data.length)
        }
        return answer
    }
}
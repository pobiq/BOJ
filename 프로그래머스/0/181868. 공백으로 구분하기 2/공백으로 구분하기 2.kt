class Solution {
    fun solution(my_string: String): MutableList<String> {
        var answer: MutableList<String> = mutableListOf()
        var arraySplit = my_string.split(" ")
        for (data in arraySplit) {
            if(!data.trim().equals("")) {
                answer.add(data)
            }
        }
        return answer
    }
}
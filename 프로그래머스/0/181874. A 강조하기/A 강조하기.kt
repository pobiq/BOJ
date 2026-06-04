class Solution {
    fun solution(myString: String): String {
        var answer: String = ""
        
        answer = myString.lowercase().replace("a", "A")
        
        return answer
    }
}
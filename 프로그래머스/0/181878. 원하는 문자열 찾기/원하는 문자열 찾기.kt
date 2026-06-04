class Solution {
    fun solution(myString: String, pat: String): Int {
        var answer: Int = 0
        if(pat.lowercase() in myString.lowercase()) {
            answer = 1
        }
        return answer
    }
}
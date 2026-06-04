class Solution {
    fun solution(binomial: String): Int {
        var answer: Int = 0
        var split_array = binomial.split(" ")
        
        var a = split_array[0]
        var op = split_array[1]
        var b = split_array[2]
        
        when(op) {
            "+" -> answer = a.toInt() + b.toInt()
            "-" -> answer = a.toInt() - b.toInt()
            "*" -> answer = a.toInt() * b.toInt()
        }
        
        return answer
    }
}
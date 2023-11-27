class Solution {
    public String solution(String s) {
        String answer = "";
        
        int[] count = new int[26];
        
        for (char c : s.toCharArray()) {
            int index = (int)c - 97;
            count[index]++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                answer += Character.toString((char)(i + 97));
            }
        }
        
        return answer;
    }
}
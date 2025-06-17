class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
		int trans = 0;
		int count = 0;
		
		while(!s.equals("1")) {
            int origin_length = s.length();
			s = s.replaceAll("0", "");
			int new_length = s.length();
            count += origin_length - new_length;
			s = Integer.toBinaryString(new_length);
			trans++;
		}
		
		answer[0] = trans;
		answer[1] = count;
        return answer;
    }
}
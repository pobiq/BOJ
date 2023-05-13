class Solution {
  public int[] solution(long n) {
      String number = Long.toString(n);
		StringBuilder sb = new StringBuilder();
		sb.append(number).reverse();
		int[] answer = new int[sb.length()];
		
		for(int i=0; i<sb.length(); i++) {
			answer[i] = Character.getNumericValue(sb.charAt(i));
		}
      return answer;
  }
}
class Solution {
  public String solution(String s, int n) {
      String answer = "";
      char[] array = s.toCharArray();
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<array.length; j++) {
				if(array[j] == 90) {
					array[j] = 65;
				}else if(array[j] == 122){
					array[j] = 97;
				}else if(array[j] == 32) {
					array[j] = 32;
				}else {
					array[j]++;
				}
			}
		}
		
	    answer = String.valueOf(array);
      return answer;
  }
}
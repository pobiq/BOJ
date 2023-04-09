class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int a_gcd = arrayA[0];
		int b_gcd = arrayB[0];
		
		for(int i=1; i<arrayA.length; i++) {
			a_gcd = gcd(a_gcd, arrayA[i]);
			b_gcd = gcd(b_gcd, arrayB[i]);
		}
		
		boolean A = false;
		boolean B = false;
		
		for(int i=0; i<arrayA.length; i++) {
			if(arrayB[i] % a_gcd == 0) {
				A = true;
			}
			
			if(arrayA[i] % b_gcd == 0) {
				B = true;
			}
		}
		
		if(!A) {
			answer = Math.max(answer, a_gcd);
		}
		
		if(!B) {
			answer = Math.max(answer, b_gcd);
		}
        
        return answer;
    }
    
    
    static int gcd(int a, int b) {
		if(a < b) {
			int temp = b;
			b = a;
			a = temp;
		}
		
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
		
	}
    
}
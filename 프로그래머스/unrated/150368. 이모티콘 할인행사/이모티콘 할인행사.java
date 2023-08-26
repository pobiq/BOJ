class Solution {
    
    static int[] discounts = {40, 30, 20, 10};
	static int subscriber = 0;
	static int total_sales = 0;
	static int n = discounts.length;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int r = emoticons.length;
		
		int[] output = new int[r];
		
		perm(users, emoticons, output, 0, r);
		
		int[] answer = {subscriber, total_sales};
		
		System.out.println(answer[0] + " " + answer[1]);
        
        return answer;
    }
    
    static void perm(int[][] users, int[] emotcions, int[] output, int depth, int r) {
		if(depth == r) {
			
			int[] prices = new int[r];
			
			int subscribe = 0;
			int total_sale = 0;
			
			for(int i=0; i<prices.length; i++) {
				prices[i] = emotcions[i] * (100 - output[i]) / 100;
				
			}
			
			
			for(int i=0; i<users.length; i++) {
				int discount = users[i][0];
				int subscribe_price = users[i][1];
				
				int sale = 0;
				
				for(int j=0; j<r; j++) {
					if(discount <= output[j]) {
						sale += prices[j];
					}
				}
				
				if(subscribe_price <= sale) {
					subscribe++;
				} else {
					total_sale += sale;
				}
				
			}
			
			if(subscriber < subscribe) {
				subscriber = subscribe;
				total_sales = total_sale;
			} else if(subscriber == subscribe) {
				if(total_sales <= total_sale) {
					total_sales = total_sale;
				}
			}
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			output[depth] = discounts[i];
			perm(users, emotcions, output, depth+1, r);
		}
	}
    
}
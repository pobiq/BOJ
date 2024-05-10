import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int[] a = new int[1001];
		int[] dp = new int[1001];
		int max = 0;
		
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++) {
			int min = 0;
			for(int j=0; j<i; j++) {
				if(a[i] < a[j])
					if(min < dp[j]) 
						min = dp[j];
				dp[i] = min + 1;
			}
			if(max < dp[i])
				max = dp[i];
		}
		
		System.out.println(max);

    }
}
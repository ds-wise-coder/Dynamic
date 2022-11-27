package 박지인.Dynamic;

import java.util.Scanner;

public class Dyna_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //남은 일수
        int n = sc.nextInt();
        //기간, 금액
        int[] t = new int[n];
        int[] p = new int[n];
        //N일에 얻을 수 있는 최대 수익
        int[] dp = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            if (i + t[i] <= n) {
                //현재 i에서 상담일(t[i])를 더해 초과하지 않는 경우 dp 배열에 금액 p[i]를 더해준다.
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            //해당 날짜에 일할 수 없다면 이전까지 일한 최대 수당을 넣어주어야 한다.
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[n]);

    }
}

package 박지인.Dynamic;

import java.util.Scanner;

public class Dyna_06 {
    static String A;
    static String B;

    static void input() {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLine();
        B = sc.nextLine();
    }
    static int solution() {
        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int k = 1; k <= m; k++) {
            dp[0][k] = k;
        }

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= m; k++) {
                if (A.charAt(i - 1) == B.charAt(k - 1)) {
                    dp[i][k] = dp[i - 1][k - 1];
                }

                else { 
                    dp[i][k] = 1 + Math.min(dp[i][k - 1], Math.min(dp[i - 1][k], dp[i - 1][k - 1]));
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
         input();
        System.out.println(solution());
    }
}

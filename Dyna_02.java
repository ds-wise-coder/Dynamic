package 박지인.Dynamic;

import java.util.Arrays;
import java.util.Scanner;

public class Dyna_02 {
    
    public int solution(int[][] map){
        int[][] dp = new int[map.length][map.length];
        //행별 최댓값을 저장할 곳
        dp[0][0] = map[0][0];
        int result=0;
        //7
        //3 9
        //8 1 0
        //2 7 4 4

        /*
         * 7
         * 10 16
         * 
         * 7
         * 10 16
         * 18 17 16
         * 
         */
        for (int i = 1; i < map.length; i++) {
            //dp 삼각형의 가장 왼쪽 값은 한줄 위의 가장 왼쪽 값에 현재 값을 더한 값이 된다
            dp[i][0] = dp[i - 1][0] + map[i][0];
            //삼각형의 가장 오른쪽의 값은 한줄 위의 가장 오른쪽 값에 현재 값을 더한 값이 된다.
            dp[i][i] = dp[i - 1][i - 1] + map[i][i];
            //나머지는 한줄 위의 오른쪽 값과 왼쪽값 중 큰 값에 현재 값을 더한 값
            for (int j = 1; j <= i - 1; j++) {
                dp[i][j]=Math.max(map[i-1][j-1],map[i-1][j]+map[i][j]);
                result=Math.max(result,dp[i][j]);
            }
        }
        return result;
    }
    
}

package 박지인.Dynamic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Dyna_01 {
    static int t;
    static int n, m;
    static int[][] map;
    static int[][] dp;
    static Map<Integer, List<Move>> moveCase = new HashMap<>();
    
    static class Move {
        int x, y;

        public Move(int x, int y) {
            this.x = x;
            this.y = y;
         }
    }

    public static void main(String[] args) {
        input();
    }
    
    public static void input() {
        //각 행에 따라 가능한 방향 
        moveCase.put(0, List.of(new Move(0, 1), new Move(1, 1)));
        moveCase.put(1, List.of(new Move(-1, 1), new Move(0, 1), new Move(1, 1)));
        moveCase.put(2, List.of(new Move(0, 1), new Move(-1, 1)));

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for (int cur = 0; cur < t; cur++) {
            n = sc.nextInt();
            m = sc.nextInt();
            dp = new int[n][m];

            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int result = exec();
            System.out.println(result);
        }
    }
    
    private static int exec() {
        for (int j = 0; j < m - 1; j++) {//열
            for (int i = 0; i < n; i++) {//행
                //방향 가져오기
                List<Move> moveList = moveCase.get(i);

                if (moveList != null) {//이동이 가능한 경우
                    int val = map[i][j];

                    for (Move mo : moveList) {
                        int nx = i + mo.x;
                        int ny = j + mo.y;

                        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                            int newVal = val + map[nx][ny];
                            //최댓값 저장
                            dp[nx][ny] = Math.max(dp[nx][ny], newVal);
                        }
                    }
                }
            }

            //하나의 열의 연산이 끝날 때마다 해당 열에 해당하는 dp[j+1]을 map배열의 행에 업데이트
            for (int q = 0; q < n; q++) {
                if (j + 1 < m) {
                    int val = dp[q][j + 1];
                    map[q][j + 1] = val;
                }
            }

        }
        //마지막 열에서 최댓값 추출
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
         return result;
    }
    
}

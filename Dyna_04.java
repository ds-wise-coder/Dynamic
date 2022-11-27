package 박지인.Dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//병사 배치하기
public class Dyna_04 {
    //병사를 배치할 때, 앞쪽에 있는 병사의 전투력이 항상 뒤쪽보다 높아야 하고
    //중복된 병사가 존재하면 안됨.
    //특정 위치에 병사를 열외 가능
    static int n;
    static int[] dp;
    static int result;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solution();
        System.out.println(result);
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
    }

    static void solution() {
        dp = new int[list.size()];
        //내림차순
        Collections.reverse(list);

        //4 2 5 8 2 11 15
        System.out.println(list);

        //dp 초기화
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < list.size(); i++) {//1~6
            for (int j = 0; j < i; j++) {
                int pre = list.get(j);
                int next = list.get(i);
                if (next > pre) {//내림차순이 아니면 i번째 값에 대한 최대 수열 길이 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        //열외해야 하는 병사의 최소수 출력
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        //전체 병사 수 - 최장길이 부분수열 = 열외수
        result = n - max;
    }
    
}

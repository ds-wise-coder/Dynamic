package 박지인.Dynamic;

import java.util.Scanner;

//못생긴 수 -> 2,3,5만을 소인수로 가지는 수, 즉 약수로 가지는 합성수
public class Dyna_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //2,3,5배한 index 값
        int n2=0, n3=0, n5=0;
        //배수 값
        int m2=2, m3=3, m5=5;
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        
        for (int i = 1; i < n; i++) {
            uglyNumbers[i] = Math.min(m2, Math.min(m3, m5));
            if (uglyNumbers[i] == m2) {
                n2++;
                m2 = uglyNumbers[n2] * 2;
            }
            if (uglyNumbers[i] == m3) {
                n3++;
                m3 = uglyNumbers[n3] * 3;
            }
            if (uglyNumbers[i] == m5) {
                n5++;
                m5 = uglyNumbers[n5] * 5;
            }
        }

        System.out.println(uglyNumbers[n-1]);

    }
}

package 박지인.Dynamic;

import java.util.Arrays;

public class Fibo_bottomup {
    static int[] arr = new int[100];

    public static void main(String[] args) {
        arr[1] = 1;
        arr[2] = 1;
        int n=20;
        for (int i = 3; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(arr[n]);//6765 
    }
}

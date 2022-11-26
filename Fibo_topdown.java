package 박지인.Dynamic;

import java.util.Arrays;

public class Fibo_topdown {
    static int[] arr = new int[100];

    static int fibo(int x){
        if (x==1 || x==2){
            return 1;
        }
        if (arr[x]!=0){
            return arr[x];
        }
        arr[x]= fibo(x-1)+fibo(x-2);
        return arr[x]; 
    }

    public static void main(String[] args) {
        Arrays.fill(arr, 0);
        System.out.println(fibo(20));
    }
}

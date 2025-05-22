package BinarySearch;

import java.util.Scanner;

public class sqrt {
    public static void main(String[] args) {
//        int n = 0;
//        int lo = 0, hi = n;
//
//        while(hi-lo > 1){
//            int mid = (lo+hi)/2;
//            if(mid*mid > n){
//                hi = mid-1;
//            }
//            else {
//                lo = mid;
//            }
//        }
//
//
//        int ans = Integer.MIN_VALUE;
//        if (lo * lo <= n) {
//            ans = lo;
//        }
//        if (hi * hi <= n) {
//            ans = hi;
//        }
//
//        if(ans != Integer.MIN_VALUE){
//            System.out.println(ans);
//        }
//        else {
//            System.out.println("not found");
//        }

        double eps = 1e-6; //for 5 decimal places  0.000001
        double x;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextDouble();

        double lo = 0, hi = x;
        while(hi-lo > eps){
            double mid  = (hi+lo)/2;
            if(mid*mid < x){
                lo = mid;
            }
            else {
                hi = mid;
            }
        }

        System.out.println(lo);
        System.out.println(Math.sqrt(x));


    }
}

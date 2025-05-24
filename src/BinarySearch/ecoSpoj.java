package BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class ecoSpoj {
    final int N = 1000000 + 10;
    int n;
    long m;
    long trees[] = new long[N];
    boolean isWoodSufficient(double h){
        long wood = 0;
        for(int i=0; i<n; i++){
            if(trees[i] >= h){
                wood += (trees[i]-h);
            }
        }

        return wood >= m;
    }

    void findMaxHeightSufficient(int n, int[] trees, int m) {
        double lo = 0, hi = 1e9;
        while (hi - lo > 1){
            double mid = (hi + lo) /2;
            if(isWoodSufficient(mid)){
                lo = mid;
            }
            else {
                hi = mid-1;
            }
        }

        if(isWoodSufficient(hi)){
            System.out.println(hi);
        }
        else if(isWoodSufficient(lo)){
            System.out.println(lo);
        }
        else {
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int prefixSum[] = new int[arr.size()+1];

    }
}

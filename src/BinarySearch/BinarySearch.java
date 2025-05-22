package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int lo = 0, hi = 7;
        int target = 5;
        int[] arr = {1,3,4,5, 5,6,7,8,9};
        while (hi-lo > 1){
            int mid = (hi+lo)/2;
            if(arr[mid] <= target){
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }

        if(arr[lo] > target){
            System.out.println(lo);
        }
        else if(arr[hi] > target){
            System.out.println(hi);
        }
        else {
            System.out.println("not found");
        }
    }
}

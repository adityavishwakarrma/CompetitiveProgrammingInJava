package Practice.Neetcode;

import java.util.HashSet;
import java.util.Set;

public class lcs {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int e: nums){
            set.add(e);
        }

        int mxLen = 0;

        for(int e: nums){
            int prev = e-1;
            if(!set.contains(prev)){
                int count = 1;
                while(set.contains(++e)){
                    count++;
                }
                mxLen = Math.max(mxLen, count);
            }
        }
        return mxLen;
    }

    public static void main(String[] args) {

    }
}
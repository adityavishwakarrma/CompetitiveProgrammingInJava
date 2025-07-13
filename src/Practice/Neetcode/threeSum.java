package Practice.Neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;
        for(int i=0; i<=n-3; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int first = nums[i];
            //find from i+1 to n-1
            for(int j=i+1; j<=n-2; j++){

                if(j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int second = nums[j];
                int third = -second-first;
                int found = Arrays.binarySearch(nums, j+1, n, third);
                if(found >= 0){
                    ans.add(List.of(first, second, third));
                }
            }
        }

        return ans;
    }
}

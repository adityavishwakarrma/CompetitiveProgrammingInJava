package Practice.Neetcode;

public class maxAreaInContainer {
    public int maxArea(int[] heights) {
        int i=0, j = heights.length-1;
        int maxArea = 0;
        while(i<j){
            int minH = Integer.MAX_VALUE;
            if(heights[i] < heights[j]){
                minH = heights[i];
                i++;
            }
            else {
                minH = heights[j];
                j--;
            }

            int area = (j-i+1) * minH;
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
}

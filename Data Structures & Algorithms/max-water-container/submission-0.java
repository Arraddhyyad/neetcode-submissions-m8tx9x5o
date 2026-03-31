class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1;
        int area = 0, max = 0;
        while(left<right){
            int h = Math.min(heights[left], heights[right]);
            area = (right-left)*h;
            max = Math.max(area,max);
            if(heights[left]<heights[right])
            left++;
            else
            right--;
        }

        return max;
    }
}

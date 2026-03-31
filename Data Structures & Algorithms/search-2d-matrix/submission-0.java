class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = 0, right= matrix[0].length-1, left = 0;

        while(row<matrix.length){
            if(matrix[row][left]<=target && matrix[row][right]>=target){
                int mid = left + (right - left)/2;
                if(matrix[row][mid]<target)
                    left = mid + 1;
                else if (matrix[row][mid]>target)
                    right = mid - 1;
                else
                    return true;
            }
            else
                {
                    row ++;
                    left = 0;
                    right = matrix[0].length -1;
                }
        }

        return false;
    }
}

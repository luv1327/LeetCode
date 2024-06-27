class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
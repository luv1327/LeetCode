class Solution {
    public int singleNonDuplicate(int[] nums) {
       int n = nums.length;
       int left = 0;
       int right = n - 1;
       while(left < right){
        int mid = left + (right - left) / 2;
        if(mid % 2 == 0 && nums[mid] == nums[mid+1] || mid % 2 != 0 && nums[mid] == nums[mid-1]){
            left = mid + 1;
        }else{
            right = mid ;
        }
       }
       return nums[left];
    }
}
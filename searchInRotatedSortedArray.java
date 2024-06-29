class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int maxIdx = findMaxIdx(nums);
        int leftSearch = searchTarget(nums,0,maxIdx,target);
        int rightSearch = searchTarget(nums,maxIdx,n - 1,target);
        return Math.max(leftSearch,rightSearch);
    }

    public int findMaxIdx(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[0]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchTarget(int[] nums,int left,int right,int target){
        int n = nums.length;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    
}


class SolutionTwo {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
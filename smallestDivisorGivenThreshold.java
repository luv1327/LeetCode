class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int left = 1;
        int right = Arrays.stream(nums).max().getAsInt();
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canDivideAndMaintain(nums,threshold,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canDivideAndMaintain(int[] nums, int threshold,int k){
        int total = 0;
        for(int num : nums){
            total += (int) Math.ceil((double) num / k);
        }

        return total <= threshold;
    }
}
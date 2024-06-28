import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int k) {
        int left = Arrays.stream(nums).max().orElseThrow();
        int right = Arrays.stream(nums).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean feasible(int[] nums, int minSum, int k) {
        int runningSum = 0;
        int count = 1;
        for (int num : nums) {
            runningSum += num;
            if(runningSum > minSum){
                runningSum = num;
                count++;
            }
        }
        return count <= k;
    }
}

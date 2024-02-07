package NeetCode150.TwoPointers;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0){
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[n-1];
        int l = 0;
        int r = n - 1;
        int ans = 0;
        while (l < r){
            if(height[l] < height[r]){
                int currentValue = leftMax - height[l];
                if(currentValue > 0){
                    ans += currentValue;
                }
                leftMax = Math.max(leftMax,height[l]);
                l+=1;
            }else{
                int currentValue = rightMax - height[r];
                if(currentValue > 0){
                    ans += currentValue;
                }
                rightMax = Math.max(rightMax,height[r]);
                r-=1;
            }
        }
        return ans;
    }
}

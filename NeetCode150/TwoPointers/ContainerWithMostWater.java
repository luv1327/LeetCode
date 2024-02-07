package NeetCode150.TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxAreaFound = 0;
        while(left < right){
            int currentLength = right - left ;
            int currentArea = currentLength * Math.min(height[left],height[right]);
            maxAreaFound = Math.max(maxAreaFound,currentArea);
            if(height[left] > height[right]){
                right-=1;
            }else{
                left +=1;
            }
        }
        return maxAreaFound;
    }
}

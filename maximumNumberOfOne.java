class Solution {
    // Function to find the row with the maximum number of 1s
    int rowWithMax1s(int arr[][], int n, int m) {
        int maxCount = 0; // Variable to store the maximum count of 1s found
        int ans = -1; // Variable to store the row index with the maximum count of 1s
        
        // Loop through each row
        for(int i = 0; i < n; i++) {
            // Find the first occurrence of 1 in the current row using binary search
            int idx = findFirstOcc(arr[i], 1);
            
            // If 1 is not found in the row, idx will be equal to the number of columns (m)
            if (idx == m) {
                continue;
            }
            
            // Calculate the count of 1s in the current row
            int currentCount = m - idx;
            
            // Update maxCount and ans if the current row has more 1s than the previous maximum
            if(currentCount > maxCount) {
                maxCount = currentCount;
                ans = i;
            }
        }
        
        return ans; // Return the index of the row with the maximum number of 1s
    }
    
    // Function to find the first occurrence of a target value in a sorted array using binary search
    public static int findFirstOcc(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        
        // Perform binary search
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        // Check if the left index points to the target value
        return (nums[left] == target) ? left : n;
    }
}

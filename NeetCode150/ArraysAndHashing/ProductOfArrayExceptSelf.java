package NeetCode150.ArraysAndHashing;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = generateSfArr(nums);
        int pf = nums[0];
        ans[0] = ans[1];
        for(int i = 1;i<n - 1;i++){
            ans[i] = pf * ans[i+1];
            pf = pf * nums[i];
        }
        ans[n-1] = pf;
        return ans;
    }
    public static int[] generateSfArr(int[] nums){
        int n = nums.length;
        int[] sf = new int[n];
        sf[n-1] = nums[n-1];
        for(int i = n-2;i >= 0;i--){
            sf[i] = sf[i+1] * nums[i];
        }
        return sf;
    }
}

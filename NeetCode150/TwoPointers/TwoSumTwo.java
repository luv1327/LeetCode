package NeetCode150.TwoPointers;

public class TwoSumTwo {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while(left < right){
            int currentSum = numbers[left] + numbers[right];
            if(currentSum == target){
                return new int[] {left+1, right+1};
            }else if(currentSum < target){
                left +=1;
            }else{
                right -=1;
            }
        }
        return new int[] {-1,-1};
    }
    
}

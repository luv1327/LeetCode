class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int left = getMax(weights);
        int right = getTotalWeight(weights);
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isFeasible(weights,days,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isFeasible(int[] weights, int days,int cargoWeightCapacity){
        int day = 1;
        int load = 0;
        for(int num : weights){
            load += num;
            if(load > cargoWeightCapacity){
                day++;
                load = num;
            }
        }
        return day <= days;
    }

    public int getTotalWeight(int[] weights){
        int total = 0;
        for(int weight : weights){
            total += weight;
        }
        return total;
    }
    public int getMax(int[] weights){
        int max = 0;
        for(int weight : weights){
            max = Math.max(weight,max);
        }
        return max;
    }
}
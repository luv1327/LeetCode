class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        int balance = numBottles;

        while(balance >= numExchange){
            int newBottles = balance / numExchange;
            ans += newBottles;
            balance = balance % numExchange + newBottles;
        }

        return ans;
    }
}


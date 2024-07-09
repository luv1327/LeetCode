class Solution {
    public int findTheWinner(int n, int k) {
        int ans = 0;
        for(int numOfPeople = 1; numOfPeople <= n; numOfPeople++){
            ans = (ans + k) % numOfPeople;
        }
        return ans + 1;
    }
}
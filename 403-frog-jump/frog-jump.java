class Solution {
    HashMap<Integer,Integer> map ;
    Boolean[][] dp;
    public boolean canCross(int[] stones) {
        if(stones[1] != 1) return false;
        map= new HashMap<>();
        for(int i=0;i<stones.length;i++){
            map.put(stones[i], i);
        }
        dp = new Boolean[stones.length][stones.length];


        return solve(stones, 0, 0);
    }

    boolean solve(int[] stones, int currStoneIdx, int prevJump){
        if(currStoneIdx == stones.length-1) return true;
        if(dp[currStoneIdx][prevJump] != null) return dp[currStoneIdx][prevJump];
        boolean res = false;
        for(int nextJump = prevJump-1;nextJump<=prevJump+1;nextJump++){
            if(nextJump>0){
                int nextStone = stones[currStoneIdx]+nextJump;
                if(map.containsKey(nextStone)){
                   res = res || solve(stones, map.get(nextStone), nextJump);   
                }
            }
        }

        return dp[currStoneIdx][prevJump] = res;


    }
}
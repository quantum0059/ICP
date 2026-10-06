class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length-1;
        int leftSum = 0, rightSum =0;
        for(int i=0;i<k;i++){
            leftSum+=cardPoints[i];
        }

        int maxPoints = leftSum;

        for(int i=k-1;i>=0;i--){
            leftSum-=cardPoints[i];
            rightSum+=cardPoints[n];

            maxPoints = Math.max(maxPoints, leftSum+rightSum);
            n--;
        }

        return maxPoints;
    }
}
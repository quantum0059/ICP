class Solution {
    public boolean canAliceWin(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int alice1Part = Arrays.stream(nums).filter(num -> num <= 9).sum();
        int alice2Part = totalSum-alice1Part;

        return ((alice1Part > alice2Part) || (alice1Part  < alice2Part));
    }
}
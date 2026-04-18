class Solution {
    public int mirrorDistance(int n) {
        long original = n;
        long rev = 0;

        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }

        return (int)Math.abs(rev - original);
    }
}
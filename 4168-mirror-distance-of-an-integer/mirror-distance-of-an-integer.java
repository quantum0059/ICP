class Solution {
    public int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(n));
        sb.reverse();

        long number = Integer.parseInt(sb.toString());

        long diff = Math.abs(number - (long)n);
        return (int)diff;

    }
}
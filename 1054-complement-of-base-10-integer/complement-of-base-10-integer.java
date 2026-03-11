class Solution {
    public int bitwiseComplement(int n) {
        String str = Integer.toBinaryString(n);

        int len = str.length();
        int res = (int)Math.pow(2, len);

        return n^(res-1);
    }
}
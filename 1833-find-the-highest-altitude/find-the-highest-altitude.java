class Solution {
    public int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length+1];

        altitude[0] = 0;
        altitude[1] = gain[0];

        for(int i=1;i<gain.length;i++){
            altitude[i+1] = altitude[i]+gain[i];  
        }

        return Arrays.stream(altitude).max().getAsInt();
    }
}
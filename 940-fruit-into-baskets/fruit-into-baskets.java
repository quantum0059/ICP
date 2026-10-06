class Solution {
    public int totalFruit(int[] fruits) {
        int lastFruit = -1;
        int secondLastFruit = -1;

        int lastFruitCount = 0;
        int curr = 0;
        int ans = 0;

        for (int fruit : fruits) {

            if (fruit == lastFruit || fruit == secondLastFruit) {
                curr++;
            } else {
                curr = lastFruitCount + 1;
            }

            if (fruit == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            ans = Math.max(ans, curr);
        }

        return ans;
    }
}
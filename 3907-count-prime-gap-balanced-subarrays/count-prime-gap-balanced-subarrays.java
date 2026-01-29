class Solution {

    static class Pair {
        int idx;
        int val;
        Pair(int i, int v) {
            idx = i;
            val = v;
        }
    }

    public int primeSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] zelmoricad = nums;
        int maxVal = Arrays.stream(nums).max().getAsInt();
        boolean[] isPrime = new boolean[maxVal + 1];
        Arrays.fill(isPrime, true);
        if (maxVal >= 0) isPrime[0] = false;
        if (maxVal >= 1) isPrime[1] = false;

        for (int i = 2; i * i <= maxVal; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxVal; j += i)
                    isPrime[j] = false;
            }
        }

        
        PriorityQueue<Pair> minPQ =
                new PriorityQueue<>((a, b) -> a.val - b.val);
        PriorityQueue<Pair> maxPQ =
                new PriorityQueue<>((a, b) -> b.val - a.val);

        Deque<Integer> primeIdx = new ArrayDeque<>();

        int left = 0;
        long count = 0;

        for (int right = 0; right < n; right++) {

            if (isPrime[nums[right]]) {
                minPQ.add(new Pair(right, nums[right]));
                maxPQ.add(new Pair(right, nums[right]));
                primeIdx.addLast(right);
            }

           
            while (!minPQ.isEmpty() && !maxPQ.isEmpty()
                    && maxPQ.peek().val - minPQ.peek().val > k) {

                left++;

                while (!primeIdx.isEmpty() && primeIdx.peekFirst() < left)
                    primeIdx.pollFirst();

                while (!minPQ.isEmpty() && minPQ.peek().idx < left)
                    minPQ.poll();

                while (!maxPQ.isEmpty() && maxPQ.peek().idx < left)
                    maxPQ.poll();
            }

            
            if (primeIdx.size() >= 2) {
                int secondLastPrimeIdx =
                        primeIdx.toArray(new Integer[0])[primeIdx.size() - 2];

                
                count += (secondLastPrimeIdx - left + 1);
            }
        }

        return (int) count;
    }
}

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> q = new ArrayDeque<>();

        int n = deck.length;
        for(int i=0;i<n;i++) q.add(i);

        int i=0;
        int[] res = new int[n];

        while(!q.isEmpty()){
           res[q.poll()] = deck[i++];

           if(!q.isEmpty()){
            q.add(q.poll());
           }
        }
        return res;
    }
}
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int steps = 0;
        while(tickets[k] != 0){
            for(int i=0;i<tickets.length;i++){
               if(tickets[i] != 0){
                  if(tickets[k] == 0){
                    break;
                 }
                tickets[i]--;
                 steps++;
               }
            }
        }

        return steps;
    }
}
class Solution {
    static class Pair{
        String s;
        int steps;
        Pair(String s, int steps){
            this.s = s;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.poll();
                String s = p.s;
                int steps = p.steps;

                if(s.equals(endWord)) return steps;
                for(String word: wordList){
                   if(!set.contains(word) && differByOne(word,s)){
                    q.add(new Pair(word, steps+1));
                    set.add(word);
                   }
                }
            }
        }
        return 0;
    }
    static boolean differByOne(String word, String curr){
        int count = 0;
        for(int i=0;i<word.length();i++){
            if(word.charAt(i) != curr.charAt(i)){
               count++;
               if(count>1) return false;
            }
        }

        return true;
    }
}
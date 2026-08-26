class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        ArrayList<String> list = new ArrayList<>();
        int left = 0;
        int count =0;
        for(int right =0;right < s.length();right++){
            if(s.charAt(right) == '1'){
                count++;
            }
            while(count > k){
                if(s.charAt(left) == '1'){
                    count--;
                }
                left++;
               
            }
             while (count == k && s.charAt(left) == '0') {
                left++;
            }
            if(count == k){
                list.add(s.substring(left, right+1));
            }
        }
        System.out.print(list.toString());

        String answer = list.size()==0 ? "":list.get(0);

        for (String str : list) {
            if (str.length() < answer.length()) {
                answer = str;
            } else if (str.length() == answer.length()
                    && str.compareTo(answer) < 0) {
                answer = str;
            }
        }
        return answer;
    }
}
class Solution {
public:
    vector<int> twoSum(vector<int>& arr, int target) {
        unordered_map<int, int > set;
        for(int i=0;i<arr.size();i++){
            int diff = target-arr[i];
            if (set.find(diff) != set.end()) {
                return {set[diff], i};
            }else{
                set[arr[i]] = i;
            }
        }
    
        return  {};
    }
};
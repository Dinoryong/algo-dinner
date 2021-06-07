class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        unordered_map<int,int> cnt;
        vector<int> answer;
        for(int num : nums){
            cnt[num]++;
        }
        
        for(int i=1;i<=nums.size();i++){
            if(!cnt[i])
                answer.push_back(i);
        }
        
        return answer;
    }
};
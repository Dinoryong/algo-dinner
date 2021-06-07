class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> answer;
        
        answer.push_back({});
        
        for(int num : nums){
            int n = answer.size();
            for(int i=0;i<n;i++){
                auto ans = answer[i];
                ans.push_back(num);
                answer.push_back(ans);
            }
        }
        
        return answer;
    }
    
};
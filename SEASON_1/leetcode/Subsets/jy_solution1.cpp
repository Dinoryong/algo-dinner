class Solution {
    vector<vector<int>> answer;
    bool visit[12] = {false,};
    int n;
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        n = nums.size();
        vector<int> num;
        dfs(nums,num,0);
        
        return answer;
    }
    
    void dfs(vector<int>& nums,vector<int>& num,int idx){
        
        answer.push_back(num);
        for(int i = idx;i < n ; i++){
            num.push_back(nums[i]);
            dfs(nums,num,i+1);
            num.pop_back();
        }
    }
    
};
class Solution {
    vector<vector<int>> answer;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<int> num;
        
        dfs(candidates,target,0,num,0);
        
        return answer;
    }
    
    void dfs(vector<int>& candidates, int target, int sum, vector<int>& num,int idx){
        if(sum == target){
            answer.push_back(num);
        }
        
        if(sum > target)
            return ;
        
        for(int i=idx;i<candidates.size();i++){
            num.push_back(candidates[i]);
            dfs(candidates,target,sum+candidates[i],num,i);
            num.pop_back();
        }
        
    }
};
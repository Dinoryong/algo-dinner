class Solution {
    bool chk[7] = {false,};
    vector<vector<int>> result;
    int n;
public:
    vector<vector<int>> permute(vector<int>& nums) {
        n = nums.size();
        for(int i=0;i<n;i++){
            vector<int> num;
            num.push_back(nums[i]);
            chk[i] = true;
            permutation(nums,num);
            chk[i] = false;
            num.pop_back();
        }
        return result;
    }
    
    void permutation(vector<int>& nums,vector<int>& num){
        if(num.size() == n){
            result.push_back(num);
            return;
        }
        for(int i=0;i<n;i++){
            if(chk[i]) continue;
            num.push_back(nums[i]);
            chk[i] = true;
            permutation(nums,num);
            chk[i] = false;
            num.pop_back();
        }
    }
};
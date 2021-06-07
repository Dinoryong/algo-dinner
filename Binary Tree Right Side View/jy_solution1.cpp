/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        queue<TreeNode*> q;
        
        vector<int> answer;
        
        if(!root) return {};
        
        q.push(root);
        
        while(!q.empty()){
            int right_chk = q.size() -1;
            int cnt = q.size();
            
            while(cnt--){
                TreeNode* cur = q.front();
                q.pop();
                if(right_chk == 0) answer.push_back(cur->val);
                right_chk--;
                if(cur->left) q.push(cur->left);
                if(cur->right) q.push(cur->right);
            }
        }
        
        return answer;
    }
};
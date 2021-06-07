/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        
        if(root == null)
            return answer;
        
        //answer.add(root.val);
        dq.add(root);
        
        while(!dq.isEmpty()) {
            int num = dq.size();
            for(int i = 0; i < num; i++) {                
                TreeNode now = dq.poll();
                if(i==num-1) {
                    answer.add(now.val);
                }
                
                if(now.left!=null) {
                    dq.add(now.left);
                }
                
                if(now.right!=null) {
                    dq.add(now.right);
                }
                
            }
        }
        
        
        
        return answer;
    }
}
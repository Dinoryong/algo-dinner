class Solution {
    vector<string> answer;
public:
    vector<string> generateParenthesis(int n) {
        
        dfs(n,0,"");
        return answer;
    }
    
    void dfs(int n, int cnt,string paren){
        if(cnt < 0)
            return;
        if(n*2 == paren.length()){
            if(cnt == 0)
                answer.push_back(paren);
            return;
        }
        
        dfs(n,cnt+1,paren+"(");
        dfs(n,cnt-1,paren+")");
        
    }
};
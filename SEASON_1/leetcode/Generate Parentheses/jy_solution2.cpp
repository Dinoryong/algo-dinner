class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> answer;
        solve(answer,"",0,0,n);
        return answer;
    }
    
    void solve(vector<string>& answer,string paren,int open, int close, int n){
        if(paren.length() == n*2){
            answer.push_back(paren);
            return;
        }   
        
        if(open < n)
            solve(answer,paren+"(",open+1,close,n);
        if(close < open)
            solve(answer,paren+")",open,close+1,n);
    }
};
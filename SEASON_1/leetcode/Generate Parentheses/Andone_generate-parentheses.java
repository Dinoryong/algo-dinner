class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answerList = new ArrayList<>();

        genfun(n,n,"",answerList);


        return answerList;
    }

    void genfun(int open, int close, String output, List<String> list) {
        if (open == 0 && close == 0){
            list.add(output);
            return;
        }
        
        if(open>0) {
            genfun(open-1,close, output + "(", list);
        }
        
        if(close>open) {
            genfun(open,close-1, output + ")", list);
        }
    }
}
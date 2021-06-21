class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int r = 0 ; r < 9 ; ++r){
            for(int c = 0 ; c < 9 ; ++c){

                char ch = board[r][c];
                
                if(ch == '.') continue;
                                
                String row = "r" + r + "/" + ch;
                String col = "c" + c + "/" + ch;
                String block = "b" + r/3 + "/" + c/3 + "/" + ch;
                
                if(set.contains(col) || set.contains(row) || set.contains(block)) return false;
                
                set.add(col);
                set.add(row);
                set.add(block);
                
                System.out.println(set.toString());
            }
        }
        
        return true;
    }
}
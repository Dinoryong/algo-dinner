class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                char c = board[i][j];
                if(c != '.') {
                    String row = i + "row" + c;
                    String col = j + "col" + c;
                    String block = i/3 + "/" + j/3 + "block" + c;
                    
                    if(set.contains(row) || set.contains(col) || set.contains(block))
                        return false;
                    
                    set.add(row);
                    set.add(col);
                    set.add(block);
                }
            }
        }
        return true;
    }
}

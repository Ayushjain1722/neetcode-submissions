class Solution {
    public boolean Helper(char board[][], String word, int i, int j, int index) {
        if (index >= word.length()) return true;
        if (i <0 || j<0 || i>board.length-1 || j>board[0].length-1) return false;
        if (board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean way1 = false;
        boolean way2 = false;
        boolean way3 = false;
        boolean way4 = false;
        // if (board[i][j] == word.charAt(index)) {
            way1 = Helper(board, word, i+1,j,index+1);
            way2 = Helper(board, word, i-1,j,index+1);
            way3 = Helper(board, word, i,j+1,index+1);
            way4 = Helper(board, word, i,j-1,index+1);
        // }
        board[i][j] = temp;
        return way1 || way2 || way3 || way4;
    }
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(Helper(board,word,i,j,0))
                        return true;
                }
            }
        }
        return false;
        
    }
}

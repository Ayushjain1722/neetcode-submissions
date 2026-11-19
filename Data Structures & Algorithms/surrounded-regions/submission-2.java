class Solution {
    public void dfs(char[][] board, int i, int j, boolean replace, boolean[][] visited) {
        if (i<0 || j<0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] == 'X')    return;
        visited[i][j] = true;
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir: dirs) {
            board[i][j] = replace ? 'X' : board[i][j];
            dfs(board, i + dir[0], j+dir[1], replace, visited);
        }
    }
    public void solve(char[][] board) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, false, visited);
            }
            if (board[i][board[0].length-1] == 'O') {
                dfs(board, i, board[0].length-1, false,visited);
            }
        }


        for (int i=0;i<board[0].length;i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, false, visited);
            }
            if (board[board.length-1][i] == 'O') {
                dfs(board, board.length-1, i, false, visited);
            }
        }

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }


    }
}

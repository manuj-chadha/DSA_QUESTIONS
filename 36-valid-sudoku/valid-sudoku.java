class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(!validate(board, board[i][j], i, j)) return false;
                }
            }
        }
        return true;
    }
    private boolean validate(char[][] board, char val, int row, int col){
        for(int i=0;i<9;i++){
            if(i!=col && board[row][i]==val){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(i!=row && board[i][col]==val){
                return false;
            }
        }
        int r=row-row%3;
        int c=col-col%3;
        for(int i=0;i<3;i++){
            int newR=r+i;
            for(int j=0;j<3;j++){
                int newC=c+j;
                if(newR!=row && newC!=col && board[newR][newC]==val){
                    return false;
                }
            }
        }
        return true;
    }
}
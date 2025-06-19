class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch=board[i][j];
                if(ch!='.'){
                    if(!validate(board, ch, i, j)) return false;
                } 
            }
        }
        return true;
    }
    public boolean validate(char[][] board, char digit, int row, int column){
        for(int i=0;i<9;i++){
            if(column!=i && board[row][i]==digit) return false;
        }
        for(int i=0;i<9;i++){
            if(row!=i && board[i][column]==digit) return false;
        }
        int r=row-row%3;
        int c=column-column%3;
        for(int i=r;i<(r+3);i++){
            for(int j=c;j<(c+3);j++){
                if((i!=row || j!=column) && board[i][j]==digit) return false;
            }
        }
        return true;
    }
}
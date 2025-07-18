class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                queue.offer(new int[]{i, 0});
                board[i][0]='V';
            }
            if(board[i][n-1]=='O'){
                queue.offer(new int[]{i, n-1});
                board[i][n-1]='V';
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                queue.offer(new int[]{0, i});
                board[0][i]='V';
            }
            if(board[m-1][i]=='O'){
                queue.offer(new int[]{m-1, i});
                board[m-1][i]='V';
            }
        }
        while(!queue.isEmpty()){
            int[] arr=queue.poll();
            int[] dx={-1, 0, 0, 1};
            int[] dy={0, -1, 1, 0};
            for(int a=0;a<4;a++){
                int nextR=arr[0]+dx[a];
                int nextC=arr[1]+dy[a];
                if(nextR>=0 && nextR<board.length && nextC>=0 && nextC<board[0].length && board[nextR][nextC]=='O'){
                    board[nextR][nextC]='V';
                    queue.offer(new int[]{nextR, nextC});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='V'){
                    board[i][j]='O';
                }
                else {
                    board[i][j]='X';
                }
            }
        }
    }
}
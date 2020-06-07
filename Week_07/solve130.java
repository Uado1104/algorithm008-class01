package Week_07;
/*
题目：给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
示例:
X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X
解释:
被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

*/

public class solve130{
    public static void main (String[] args) {

    }
}
//从边界出发，先把边界上和O连通点找到, 把这些变成'B',然后遍历整个board把 O 变成 X, 把 B 变成 O
//时间复杂度 : dfs，O(n^2)
//空间复杂度 : O(n)。
class Solution {
    int[][] dirs ={{1,0},{0,1},{-1,0},{0,-1}};
    public void solve(char[][] board) {
    if(board == null||board.length == 0||board[0].length == 0)return;
    int row_len = board.length;
    int col_len = board[0].length;
    //遍历第一行和最后一行
    for(int col = 0;col < col_len;col++){
        if(board[0][col] == 'O')dfs(0,col,board,row_len,col_len);
        if(board[row_len-1][col] == 'O')dfs(row_len-1,col,board,row_len,col_len);
    }
    //遍历列
        for(int row = 0;row < row_len;row++){
            if(board[row][0] == 'O')dfs(row,0,board,row_len,col_len);
            if(board[row][col_len-1] == 'O')dfs(row,col_len-1,board,row_len,col_len);
        }
    //处理
        for(int row = 0;row < row_len;row++){
            for(int col = 0;col < col_len;col++){
                if(board[row][col] == 'O')board[row][col] = 'X';
                if(board[row][col] == 'B')board[row][col] = 'O';
            }
        }

    }
    //递归查找有无零
    private void dfs(int row,int col,char[][] board,int row_len,int col_len){
        //处理当前
        board[row][col] = 'B';
        for(int[] dir : dirs){
            int temp_row = row + dir[0];
            int temp_col = col + dir[1];
            //递归边界
            if(temp_row < 0 || temp_row>=row_len||temp_col<0||temp_col>=col_len||board[temp_row][temp_col]!='O')continue;
            //下探
            dfs (temp_row,temp_col,board,row_len,col_len);
        }
    }
}
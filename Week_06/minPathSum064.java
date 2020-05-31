package Week_06;
/*
题目：给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
示例:
输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
*/

public class minPathSum064{
    public static void main (String[] args) {

    }
}

//时间复杂度 :
//空间复杂度 :
//动态规划：遍历每一格，遍历方式是'/'的方式遍历，每一格的最小路径取决于左和上一格中较小的那个。
class Solution20200531 {
    public int minPathSum(int[][] grid) {
        //判例
        if(grid == null ||grid.length <1||grid[0].length<1)return 0;
        //定义边界
        int row_len = grid.length;
        int col_len = grid[0].length;
        for(int row = 0 ;row < row_len;row++){
            for(int col = 0;col < col_len;col++) {
                if (row == 0 && col == 0) {
                    continue;
                } else {
                    if (row == 0) {
                        grid[row][col] += grid[row][col - 1];
                    } else if (col == 0) {
                        grid[row][col] += grid[row - 1][col];
                    } else {
                        grid[row][col] += Math.min (grid[row][col - 1], grid[row - 1][col]);
                    }
                }
            }
        }
        return grid[row_len-1][col_len-1];
    }
}
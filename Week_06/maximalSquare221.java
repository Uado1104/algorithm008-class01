package Week_06;
/*
题目：在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
示例:
输入:
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4
*/

public class maximalSquare221{
    public static void main (String[] args) {

    }
}

//时间复杂度 : O(N)
//空间复杂度 : O(N)。
//动态规划：某一例为1的格子的最大正方形面积为左、左上、上格子正方形面积的最小值
class Solution {
    public int maximalSquare(char[][] matrix) {
        //判例
        if(matrix == null || matrix.length < 1 ||matrix[0].length <1)return 0;
        //定义边界
        int row_len = matrix.length;
        int col_len = matrix[0].length;
        int res = 0;
        //自定义dp[]
        int[][] dp = new int[row_len + 1][col_len + 1];
        for(int row = 0;row < row_len;row++){
            for (int col = 0;col< col_len;col++){
                if(matrix[row][col] == '1'){
                    dp[row+1][col+1] = Math.min (Math.min(dp[row][col],dp[row][col+1]),dp[row+1][col])+1;
                    res = Math.max (res,dp[row+1][col+1]);
                }
            }
        }
        return res*res;
    }
}
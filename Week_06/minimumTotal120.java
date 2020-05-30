package Week_06;
/*
题目：给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
例如，给定三角形：
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
说明：
如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
*/

import java.util.List;

public class minimumTotal120{
    public static void main (String[] args) {

    }
}
//从上向下遍历数组，当前行从左向右遍历，开辟暂存空间，left为上一行左，right为上一行右，dp[i]记录当前加左和右的较小的一个
//遍历最后一行的处理结果
//时间复杂度 : 由于是标准的二分查找，时间复杂度为O(\log(m n))
//空间复杂度 : O(1)。
//
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null|| triangle.size ()== 0){
            return 0;
        }
        int[] dp = new int[triangle.size ()];
        dp[0] = triangle.get (0).get (0);
        int left = 0,right;
        for(int i = 1;i < triangle.size () ;i++){
            for(int j = 0;j <=i;j++){
                //暂存right
                right = dp[j];
                if(j == 0 ){
                    dp[j] = triangle.get (i).get (0) + right;
                }else if(j == i){
                    dp[j] = triangle.get (i).get (i) + left;
                }else{
                    dp[j] = Math.min (left,right) + triangle.get (i).get (j);
                }
                //更新left
                left = right;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0;i < triangle.size ();i++){
            res = Math.min (res,dp[i]);
        }
        return res;
    }
}
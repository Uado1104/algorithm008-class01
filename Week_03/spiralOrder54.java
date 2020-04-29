package Week_03;
/*
题目：给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
示例 1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
import java.util.ArrayList;
import java.util.List;

public class spiralOrder54 {
    public static void main (String[] args) {

    }
}
//从外部向内部逐层遍历打印矩阵，最外面一圈打印完，里面仍然是一个矩阵
//统计矩阵的层数，每一层最多会占据两行或者两列，最少会占据一行或者一列元素，只有一层或者一列，也算一层
//从左向右;
//从上往下;
//从右往左，如果这一层只有1行，那么第一个循环已经将该行打印了，这里就不需要打印了，即（m-1-i ）!= i
//从下往上，如果这一层只有1列，那么第2个循环已经将该列打印了，这里不需要打印，即(n-1-i) != i

class solution1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<> ();
        if(matrix == null || matrix[0].length == 0 ){
            return list;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int count = (Math.min (m,n)+1)/2;
        while (i<count){
            for(int j = i;j< n - i;j++){
                list.add (matrix[i][j]);
            }
            for(int j = i + 1;j<m-i;j++){
                list.add(matrix[j][n-1-i]);
            }
            for(int j = n-1 - i -1;j>i && (m-1-i)!=inumOfBurgers1276.java;j--){
                list.add(matrix[m-i][j]);
            }
            for(int j = m-1-i-1;j>i && (n-1-i)!=i;j--){
                list.add(matrix[j][i]);
            }
            i++;
        }
        return list;
    }
}
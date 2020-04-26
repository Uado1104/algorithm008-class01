package Week_02;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/*
题目：编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
示例 1：
输入：
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出：
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2：
输入：
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出：
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
*/
public class setZeroes0108 {
    private static void main(String args[]) {
    }
}

// 通过递归来解决问题，深度优先搜索

class solution1 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] a = new int[row*col];
        int[] b= new int[row*col];
        int numa=0;
        int numb=0;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(matrix[i][j]==0){
                  a[numa]=i;
                  numa++;
                  b[numb]=j;
                  numb++;
                }
            }
        }

        for(int m = 0;m<numa;m++){
            for(int j = 0;j<col;j++){
                matrix[a[m]][j] = 0;
            }
        }
        for(int n = 0;n<numb;n++){
            for(int i = 0;i<row;i++){
                matrix[i][b[n]] = 0;
            }
        }  
    }
}
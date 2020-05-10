package Week_03;
/*
题目：n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
示例:
输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],
 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
提示：
皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，
就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自 百度百科 - 皇后 ）
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class solveNQueens51 {
    public static void main (String[] args) {

    }
}

//思路：回溯法
//按列循环，攻击位考虑行、列、主对角线和次对角线。
//行考虑i=常数，列考虑j=常数，主对角线hill'/'考虑i+j=常数，次对角线dale'\'考虑i-j=常数
//复杂度：O(n)
class Solution2020050901 {

    int rows[];
    //定义主对角线
    int main[];
    //定义次对角线
    int secondary[];
    int n;
    int[] lines = new int[];
    //定义输出
    List<List<String>> res = new ArrayList<> ();
    int queens[];

    public List<List<String>> solveNQueens (int n) {
        rows = new int[n];
        main = new int[2 * n - 1];
        secondary = new int[2 * n - 1];
        queens = new int[n];
        this.n = n;
        backtrack (0);
        return res;
    }

    // 在一行中放置一个皇后
    public void backtrack (int row) {
        // 循环终止条件
        if (row >= n) return;
        //处理当前层
        for (int col = 0; col < n; col++) {
            if (notUnderAttack (row, col)) {
                placeQueen (row, col);
                if (row == n - 1) addSolution;
                // 下探到下一层
                backtrack (row + 1);
                // 更新状态数据
                removeQueen (row, col);
            }


            // 判断 row 行，col 列这个位置有没有被其他方向的皇后攻击
            private boolean notUnderAttack ( int row, int col){

            }
            // 在指定的位置上放置皇后
            // 移除指定位置上的皇后
            // 将满足条件的皇后位置放入output中
        }
    }
}

class Solution2 {

    private boolean[] col;
    private boolean[] master;
    private boolean[] slave;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens (int n) {
        this.n = n;
        res = new ArrayList<> ();
        if (n == 0) {
            return res;
        }


        col = new boolean[n];
        master = new boolean[2 * n - 1];
        slave = new boolean[2 * n - 1];
        Stack<Integer> stack = new Stack<> ();

        backtrack (0, stack);
        return res;
    }

    private void backtrack (int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board (stack, n);
            res.add (board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col[i] && !master[row + i] && !slave[row - i + n - 1]) {
                stack.add (i);
                col[i] = true;
                master[row + i] = true;
                slave[row - i + n - 1] = true;

                backtrack (row + 1, stack);

                slave[row - i + n - 1] = false;
                master[row + i] = false;
                col[i] = false;
                stack.pop ();
            }
        }
    }

    private List<String> convert2board (Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<> ();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder ();
            for (int i = 0; i < n; i++) {
                stringBuilder.append (".");
            }
            stringBuilder.replace (num, num + 1, "Q");
            board.add (stringBuilder.toString ());
        }
        return board;
    }
}

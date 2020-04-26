package Week_02;

import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

/*
题目：给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。
示例:
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
*/
public class minDepth111 {
    private static void main(String args[]) {
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 通过递归来解决问题，深度优先搜索
// 时间复杂度：O(N)，每个节点只访问一次。
// 空间复杂度：O(N)
/*
 * 1.叶子节点的定义是左孩子和右孩子都为null时叫做叶子节点 2.当root节点左右孩子都为空时，返回1；
 * 3.当root节点左右孩子有一个为空时，返回不为空的孩子节点的深度 4.点那个root节点左右孩子都不为空时，返回左右孩子较小深度的节点值
 */
class solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_height = minDepth(root.left);
        int right_height = minDepth(root.right);
        return root.left == null || root.right == null ? left_height + right_height + 1
                : Math.min(left_height, right_height) + 1;
    }
}

// 思路：广度优先搜素
class solution2 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                // 到达叶子节点
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
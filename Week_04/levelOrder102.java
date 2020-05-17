package Week_04;
/*
题目：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例：
二叉树：[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
*/

import java.util.*;

/*
广度优先搜索（BFS）
我们按照高度的顺序从上到下逐级扫描树。更高级别的节点将先于较低级别的节点访问。
深度优先搜索（DFS)
在这个策略中，我们采用深度作为优先顺序，这样我们就可以从一个根开始，一直延伸到某个叶，然后回到根，到达另一个分支。
根据根节点、左节点和右节点之间的相对顺序，可以进一步将DFS策略区分为 preorder、inorder 和 postorder 。
DFS 策略更适合，因为相邻节点之间的链接自然地按顺序编码，这对后面的反序列化任务非常有帮助。

 */
public class levelOrder102 {
    public static void main (String[] args) {

    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

//序列化
class Solution2020051101 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        while(queue.size()>0) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer> ();
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if(t.left!=null) {
                    queue.add(t.left);
                }
                if(t.right!=null) {
                    queue.add(t.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
 }
package Week_03;
/*
题目：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
示例 1:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
说明:
所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
*/
import java.util.Stack;
public class lowestCommonAncestor68 {
    public static void main (String[] args) {

    }
}

//首先在二叉树中搜索给定的节点 pp 和 qq，然后找到它们的最近公共祖先。我们可以使用普通的树遍历来搜索这两个节点。
//一旦我们达到所需的节点 pp 和 qq，我们就可以进行回溯并找出最近的公共祖先。
//递归：
//先深度遍历该树。当遇到节点 p 或 q 时，返回一些布尔值作为标记。
//标记有助于确定是否在任何路径中找到了所需的节点。最不常见的祖先将是两个子树递归都返回 true 标记的节点。
//它也可以是一个节点，它本身是 p 或 q 中的一个，对于这个节点,子树递归返回一个 true 标记。
//

class solution{
        private TreeNode ans;

    public Solution() {
            // Variable to store LCA node.
            this.ans = null;
        }

        private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

            // If reached the end of a branch, return false.
            if (currentNode == null) {
                return false;
            }

            // Left Recursion. If left recursion returns true, set left = 1 else 0
            int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

            // Right Recursion
            int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            // If the current node is one of p or q
            int mid = (currentNode == p || currentNode == q) ? 1 : 0;


            // If any two of the flags left, right or mid become True
            if (mid + left + right >= 2) {
                this.ans = currentNode;
            }

            // Return true if any one of the three bool values is True.
            return (mid + left + right > 0);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Traverse the tree
            this.recurseTree(root, p, q);
            return this.ans;
        }
    }

//在前面的方法中，LCA 在回溯过程中被发现。但摆脱回溯过程本身也是可行的。
//在这种方法中，我们总是有一个指向可能 LCA 的指针，当我们能够同时找到这两个节点时，返回指针作为答案。
//从根节点开始。将 (root, root_state) 放在栈上。root_state 定义要遍历该节点的一个子节点还是两个子节点。
//当栈不为空时，查看栈的顶部元素，该元素表示为 (parent_node, parent_state) 。
//在遍历 parent_node 的任何子节点之前，我们检查 parent_node 本身是否是 p 或 q 中的一个。
//当我们第一次找到 p 或 q 的时候，设置一个布尔标记，名为 one_node_found 为 true 。
//还可以通过在变量 LCA_index 中记录栈的顶部索引来跟踪最近的公共祖先。因为栈的所有当前元素都是我们刚刚发现的节点的祖先。
//第二次 parent_node == p or parent_node == q 意味着我们找到了两个节点，我们可以返回 LCA node 。
//每当我们访问 parent_node 的子节点时，我们将 (parent_node, updated_parent_state) 推到栈上。
//我们更新父级的状态为子级/分支已被访问/处理，并且相应地更改状态。
//当状态变为 BOTH_DONE 时，最终会从栈中弹出一个节点，这意味着左、右子树都被推到栈上并进行处理。
//如果 one_node_found 是 true 的，那么我们需要检查被弹出的顶部节点是否可能是找到的节点的祖先之一。
//在这种情况下，我们需要将 LCA_index 减一。因为其中一位祖先被弹出了。
//当同时找到 p 和 q 时，LCA_index 将指向栈中包含 p 和 q 之间所有公共祖先的索引。并且 LCA_index 元素具有 p 和 q 之间的最近公共祖先。

class Solution {

    // Three static flags to keep track of post-order traversal.
    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
    private static int BOTH_PENDING = 2;

    // Left traversal done.
    private static int LEFT_DONE = 1;

    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();

        // Initialize the stack with the root node.
        stack.push(new Pair<TreeNode, Integer>(root, Solution.BOTH_PENDING));

        // This flag is set when either one of p or q is found.
        boolean one_node_found = false;

        // This is used to keep track of the LCA.
        TreeNode LCA = null;

        // Child node
        TreeNode child_node = null;

        // We do a post order traversal of the binary tree using stack
        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();

            // If the parent_state is not equal to BOTH_DONE,
            // this means the parent_node can't be popped off yet.
            if (parent_state != Solution.BOTH_DONE) {

                // If both child traversals are pending
                if (parent_state == Solution.BOTH_PENDING) {

                    // Check if the current parent_node is either p or q.
                    if (parent_node == p || parent_node == q) {

                        // If one_node_found was set already, this means we have found
                        // both the nodes.
                        if (one_node_found) {
                            return LCA;
                        } else {
                            // Otherwise, set one_node_found to True,
                            // to mark one of p and q is found.
                            one_node_found = true;

                            // Save the current top element of stack as the LCA.
                            LCA = stack.peek().getKey();
                        }
                    }

                    // If both pending, traverse the left child first
                    child_node = parent_node.left;
                } else {
                    // traverse right child
                    child_node = parent_node.right;
                }

                // Update the node state at the top of the stack
                // Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state - 1));

                // Add the child node to the stack for traversal.
                if (child_node != null) {
                    stack.push(new Pair<TreeNode, Integer>(child_node, Solution.BOTH_PENDING));
                }
            } else {

                // If the parent_state of the node is both done,
                // the top node could be popped off the stack.
                // Update the LCA node to be the next top node.
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }

            }
        }

        return null;
    }
}


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
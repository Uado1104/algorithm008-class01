package Week_06;
/*
题目：给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :
返回其层序遍历:
[
     [1],
     [3,2,4],
     [5,6]
]
说明:
树的深度不会超过 1000。
树的节点总数不会超过 5000。

*/

import java.util.*;

public class ladderLength127{
    public static void main (String[] args) {

    }
}

//时间复杂度 : O(N)。
//空间复杂度 : O(N)。
//中序遍历
class solution20200519 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<> ();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<> ();
        queue.add (root);
        while (!queue.isEmpty()){

        }
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

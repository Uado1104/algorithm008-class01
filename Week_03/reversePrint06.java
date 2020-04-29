package Week_03;
/*
题目：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
示例 1：
输入：head = [1,3,2]
输出：[2,3,1]
限制：
0 <= 链表长度 <= 10000

*/
import java.util.LinkedList;

public class reversePrint06 {
    public static void main (String[] args) {

    }
}

//辅助栈法
//链表特点：只能从前至后访问每个节点。
//这种先入后出的需求可以借助栈来实现。
//算法流程：
//入栈：遍历链表，将各节点值 push 入栈。（借助 LinkedList 的addLast()方法）。
//出栈：将各节点值 pop 出栈，存储于数组并返回。（​新建一个数组，通过 popLast() 方法将各元素存入数组，实现倒序输出）。
//复杂度分析：
//时间复杂度 O(N)：入栈和出栈共使用 O(N)时间。
//空间复杂度 O(N)：辅助栈 stack 和数组 res 共使用 O(N)的额外空间。
//图解以 Java 代码为例，Python 无需将 stack 转移至 res，而是直接返回倒序数组。

class solution1 {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<> ();
        while (head != null){
            stack.addLast (head.val);
            head = head.next;
        }
        int[] res = new int[stack.size ()];
        for(int i = 0;i < res.length;i++){
            res[i] = stack.removeLast ();
        }
        return res;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
package Week_04;
/*
题目：给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：
输入：head = [1,2], pos = 0
输出：tail connects to node index 0
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：
输入：head = [1], pos = -1
输出：no cycle
解释：链表中没有环。
进阶：
你是否可以不用额外空间解决此题？
*/

import java.util.Arrays;

public class detectCycle142 {
    public static void main (String[] args) {

    }
}
 class ListNode {
     int val;
     ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

//双指针法：分成两个阶段，第一阶段fast是slow的两倍，当fast和slow第一次相遇，进入第二阶段，fast指向head，一格递增，再次相遇点即为所求点。
//时间复杂度：O(N)；空间复杂度：O(1)


class Solution202002051701 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (true){
            if(fast == null || fast.next == null )return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)break;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
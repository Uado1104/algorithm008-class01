package Week_02;

import java.util.*;
import java.util.List;

/*
题目：合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
示例:
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
*/
public class mergeKLists23 {
    private static void main(String args[]) {
    }
}

//方法1——利用堆做排序：1.把是那个链表全都放入堆内；2.由堆根据节点堆val自动排序，输出堆顶元素。
// 时间复杂度：
// 空间复杂度：
class solution1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null||lists.length==0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val;o2.val);
            }
        });
        //遍历链表数组，然后将每个链表堆每个节点都放入堆中
        for (int i = 0;i<List.length;i++){
            while(Lists[i]!= null){
                queue.add(List[i]);
                List[i] = lists[i].next;
            }
        ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
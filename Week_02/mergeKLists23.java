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


//思路：1.创建一个小根堆，并定义好排序函数；2.只把k个链表的第一个节点放入堆中；
//3.不断从堆中取出节点，如果这个节点还有下一个节点
//时间复杂度：O(N log k)
class solution2{
    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0){
            return  null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return (o1.val - o2.val);
            }
        });
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        //只把k个链表的第一个节点放入堆中
        for(int i = 0;i<lists.length;i++){
            ListNode head = lists[i];
            if(head != null){
                queue.add(head);
            }
        }
        while(queue.size()>0){
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if(node.next != null){
                queue.add(node.next);
            }
        }
        cur.next = null;
        return dummy.next;

    }
}

//思路：两两合并
//将list[0]作为最终合并的链表，然后将list[0]和lists[1]合并成lists[0-1]
//再将lists[0-1]和lists[2]合并，如此反复最终lists[0]就是最终结果
//时间复杂度：O(N log k)
class solution{
    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null ||lists.length == 0){
            return  null;
        }
        ListNode res = lists[0];
        for(int i = 1;i<lists.length;i++){
            res = merge(res,lists[i]);
        }
        return res;
    }
    private ListNode merge(ListNode a , ListNode b){
        if(a == null || b == null){
            return (a==null)?b:a;
        }
        if(a.val <= b.val){
            a.next = merge(a.next,b);
            return a;
        }else{
            b.next = merge(a,b.next);
            return b;
        }
    }
}



//思路：分治，不断减小规模，再不断合并扩大的过程
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
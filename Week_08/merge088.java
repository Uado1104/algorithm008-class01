package Week_08;
/*
题目：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
*/
import java.util.PriorityQueue;
import java.util.Queue;

public class merge088 {
    public static void main (String[] args) {

    }
}
class Solution20200614 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p_left = m-1 ;
        int p_right = n-1;
        //set the pointer for the num1
        int p = m + n -1 ;
        //当还有元素比较时
        while((p_left >= 0)&&(p_right > =0)){
            nums1[p--] = (nums1[p_left] < nums2[p_right])?nums2[p_right--]:nums1[p_left--];
        }
        //弥补其它缺失的元素
        System.arraycopy (nums2,0,nums1,0,p_right+1);
    }
}
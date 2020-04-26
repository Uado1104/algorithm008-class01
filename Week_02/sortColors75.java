package Week_02;
/*
题目：给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意:
不能使用代码库中的排序函数来解决这道题。
示例:
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：
一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？

*/

public class sortColors75 {
    public static void main(String[] args) {

    }
}
//思路：沿着数组移动curr指针，若num[curr] = 0，则将其与 num[p0]互换；若num[curr] = 2，则与num[p2]互换。
//1.初始化0的最优边界，初始化2的最左边界，初始化当前的元素序号
//2.遍历数组，当前元素=0，交换curr和p0，curr和p0指针右移；若=2，交换curr和p2，curr右移，p2左移；若=1，指针右移


class Solution1{
    public void sortColors(int[] nums){
        int p0 = 0,curr = 0,p2 = nums.length;
        while (curr < p2){
            if(nums[curr] == 0){
                swap(nums,curr,p0);
                curr++;
                p0++;
            }else if(curr == 1){
                curr++;

            }else {
                p2--;
                swap(nums,curr,p2);
            }
        }
    }
    private void swap(int[] nums ,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b] ;
        nums[b] = temp;
    }

}

class Solution2{
    public void sortColors(int[] nums) {
        int p0 = 0 ;int p2 = nums.length;int curr = 0;
        if(nums.length<2) return;
        while (curr<nums.length){
            if(nums[curr] == 0){
                swap(nums,curr,p0);
                curr++;
                p0++;
            }else if(nums[curr] == 1){
                curr ++;
            }else{
                p2--;
                swap(nums,curr,p2);
            }
        }
    }
    private void swap(int[] nums,int a,int b ){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
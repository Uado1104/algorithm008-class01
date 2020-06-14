package Week_08;
/*
题目：给你两个数组，arr1 和 arr2，
arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
示例：
输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
提示：
arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
*/

public class relativeSortArray1122 {
    public static void main (String[] args) {

    }
}

//
public class Solution20200610 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cur = new int[1001];
        int[] ans = new int[arr1.length];
        //循环遍历arr1，记录arr1每个元素重复的次数
        for(int i = 0;i<arr1.length;i++){
            cur[arr1[i]]++;
        }
        //循环遍历arr2，并将cur中与arr2相同的元素加入ans中
        int num = 0;
        for (int i = 0; i<arr2.length;i++){
            while (cur[arr2[i]]>0){
                ans[num++] = arr2[i];
                cur[arr2[i]]--;
            }
        }
        //循环遍历剩余的cur，将其按顺序输出
        for(int i = 0; i < 1001;i++){
            while (cur[i]>0){
                ans[num++] = i;
                cur[i]--;
            }
        }
        return ans;
    }
}
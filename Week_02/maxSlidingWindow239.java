package Week_02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/*
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。
示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
1 [3  -1  -3] 5  3  6  7       3
1  3 [-1  -3  5] 3  6  7       5
1  3  -1 [-3  5  3] 6  7       5
1  3  -1  -3 [5  3  6] 7       6
1  3  -1  -3  5 [3  6  7]      7
 
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

*/
public class maxSlidingWindow239 {
    private static void main(String args[]) {

    }
}

// 我的思路：用队列，1.判断数组长度是否大于k，2.用队列不断遍历数组，直到最后一位k，3.输出每次遍历的最大值到数组中；4.返回数组的前k位
// 一共有n-k+1个窗口。
// 时间复杂度：O(Nk)
// 空间复杂度：O(N-k+1)
class solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0)
            return new int[0];
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }
}

// 双向队列，该数据结构可以从两端以常数时间压入/弹出元素。

class solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
         * 我们可以用一个单调递减队列。单调递减队列添加元素的算法如下。
         * 如果当前元素比队列的最后一个元素大，那么就将最后一个元素出队，重复这步直到当前元素小于队列的最后一个元素或者队列为空。进行下一步。
         * 如果当前元素小于等于队列的最后一个元素或者队列为空，那么就直接将当前元素入队。
         * 按照上边的方法添加元素，队列中的元素就刚好是一个单调递减的序列，而最大值就刚好是队头的元素。
         * 当队列的元素等于窗口的大小的时候，由于添加元素的时候我们进行了出队操作，所以我们不能像解法二那样每次都删除第一个元素，
         * 需要先判断一下队头元素是否是我们要删除的元素
         */
        // 时间复杂度位O(n)
        Deque<Integer> max = new ArrayDeque<>();
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int result[] = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                if (max.peekFirst() == nums[i - k]) {
                    max.removeFirst();
                }
            }
            while (!max.isEmpty() && nums[i] > max.peekLast()) {
                max.removeLast();
            }

            max.addLast(nums[i]);
            if (i >= k - 1) {
                result[index++] = max.peekFirst();
            }
        }
        return result;
    }
}

class solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
         * class solution2 { public int[] maxSlidingWindow(int[] nums, int k) { /*
         * 算法的思想是将输入数组分割成有 k 个元素的块。若 n % k != 0，则最后一块的元素个数可能更少。 算法十分直截了当： 从左到右遍历数组，建立数组
         * left。 从右到左遍历数组，建立数组 right。
         */
        // 时间复杂度位O(n)
        // 时间复杂度位O(n)
        int n = nums.length;
        if (n * k == 0)
            return new int[0];
        if (k == 1)
            return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            if (i % k == 0)
                left[i] = nums[i];
            else
                left[i] = Math.max(left[i - 1], nums[i]);
            int j = n - i - 1;
            if ((j + 1) % k == 0)
                right[j] = nums[j];
            else
                right[j] = Math.max(right[j + 1], nums[j]);
        }
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        return output;
    }
}

// 思路：遍历一遍，指针从左到右，每隔k个数，输出该位与左边届的最大值；
// 指针从右到左，输出该位与右边界的最大值；
// 遍历同一个边界两边的最大值，输出最大值
// 判断例外情况
class Solution4 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0)
            return new int[0];
        if (len == 1)
            return nums;
        int[] left = new int[len];
        left[0] = nums[0];
        int[] right = new int[len];
        right[len - 1] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            if (i % k == 0)
                left[i] = nums[i];
            else
                left[i] = Math.max(nums[i], left[i - 1]);
            int j = len - i - 1;
            if ((j + 1) % k == 0)
                right[j] = nums[j];
            else
                right[j] = Math.max(nums[j], right[j + 1]);
        }
        int[] output = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            output[i] = Math.max(left[i + k - 1], right[i]);
        }
        return output;
    }
}
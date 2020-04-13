package Week_01;
public class solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int next = 0;
        if (len < 2) {
            return;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[next] = nums[i];
                next++;
            }
        }

        for (int i = next; i < len; i++) {
            nums[i] = 0;
        }
    }
}

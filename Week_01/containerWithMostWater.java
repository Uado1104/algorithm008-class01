package Week_01;

public class containerWithMostWater {
    public int maxArea(int[] a) {
        //初始化最大值max
        int max = 0;
        //初始化指针i,从左侧开始；初始化指针j，从右侧开始；当i>=j时，跳出循环
        for (int i = 0, j = a.length - 1; i < j;) {
            /*
            逻辑：保留更长的指针所指的元素，移动更短的指针
            知识点：?是java里唯一的三元运算符。如果?前面的式子为真，那么就返回冒道号:左边的值；否则返回右边的值。
            该式子先判断a[i]是否小于a[j]；
            当为真时，将a[i]赋给minHeight，i自加1；
            当为假时，将a[j]赋给minHeight，i自减1；            
            */
            
            int minHeight = a[i] < a[j] ? a[i++] : a[j--];
            //定义面积为指针差+1，在乘以minHeight
            int area = (j - i + 1) * minHeight;
            //判断是否与缓存当最大值比较，更大时将其赋予缓存值max
            max = Math.max(max, area);
        }
        return max;
    }
}
// 1.暴力求解，枚举法，left bar x ,right bar y ,(y-x)height_diff
// O(n^2)

class solution {
    public int maxArea(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            for (int j = i + 1; j < a.length; ++j) {
                int area = (j - i) * Math.min(a[i], a[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
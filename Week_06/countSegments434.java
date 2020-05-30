package Week_06;
/*
题目：统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
请注意，你可以假定字符串里不包括任何不可打印的字符。
示例:
输入: "Hello, my name is John"
输出: 5
解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。

*/

public class countSegments434{
    public static void main (String[] args) {

    }
}

//时间复杂度 : 由于是标准的二分查找，时间复杂度为O(\log(m n))
//空间复杂度 : O(1)。
//二分查找
class Solution {
    public int countSegments(String s) {
        int len = s.length();
        if(len < 1)return 0;
        int count = 0,cur = 0;
        for(int i =0;i < len ;i++)
            if(s.charAt (i) != ' '){
                if(cur == 0){
                    count++;
                }
                else if(cur == 1) {
                    continue;
                }
                cur = 1;
            }else if(s.charAt (i) == ' '){
                cur = 0;
            }
        return count;
    }
}
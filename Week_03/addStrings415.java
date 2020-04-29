package Week_03;
/*
题目：给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
注意：
num1 和num2 的长度都小于 5100.
num1 和num2 都只包含数字 0-9.
num1 和num2 都不包含任何前导零。
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
*/

import java.lang.StringBuilder;
import java.lang.StringBuffer;
public class addStrings415 {
    public static void main (String[] args) {

    }
}

//思路：倒序遍历，控制进位代码
//复杂度：O(n)
class solution1 {
    public int[] addStrings (String num1, String num2) {
        StringBuffer res = new StringBuffer ("");
        int i = num1.length()- 1;
        int j = num2.length()- 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt (i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt (j) - '0' : 0;
            int temp = n1 + n2 + carry;
            carry = temp / 10;
            res.append (temp % 10);
            i--;
            j--;
        }
        if (carry == 1) res.append ("1");
        return res.reverse() ;
    }
}
package Week_09;

import java.util.ArrayList;

/*
题目：给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
示例 1:
输入: s = "egg", t = "add"
输出: true
示例 2:
输入: s = "foo", t = "bar"
输出: false
示例 3:
输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。
*/
public class isIsomorphic205 {
    public static void main (String[] args) {

    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len_s = s.length ();
        int[] mapS = new int[128];
        int[] mapT = new int[128];
        for(int i = 0; i < len_s;i++){
            char s1 = s.charAt (i);
            char t1 = t.charAt (i);
            if(mapS[s1] != mapT[t1])return false;
            else{
                if(mapS[s1] == 0){
                    mapS[s1] = i+1;
                    mapT[t1] = i+1;
                }
            }
        }
        return true;
    }
}
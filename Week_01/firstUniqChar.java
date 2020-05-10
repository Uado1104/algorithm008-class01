package Week_01;
/*
题目在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
实例：
s = "abaccdeff"
返回 "b"
s = "" 
返回 " "

*/
import java.util.HashMap;  
//方法1:哈希表
//时间复杂度O(n)，空间复杂度O(n)
public class firstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(char c : sc)
            if(dic.get(c)) return c;
        return ' ';
    }
}

class Solution {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (count[c - 'a'] == 1)
                return c;
        }
        return ' ';
    }
}
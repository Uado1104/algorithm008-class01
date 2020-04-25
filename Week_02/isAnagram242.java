package Week_02;
/*
题目：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
示例1：
输入: s = "anagram", t = "nagaram"
输出: true
示例 2:
输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。
*/

import java.util.Arrays;


public class isAnagram242{
    public static void main(String[] args) {
        String s = "1234";
        String t = "2345";
        solution1 a =new isAnagram(s,t) ;
    }
}

//1.暴力法
//思路：通过将s的字母重新排列成t来生成变位词。因此，如果T是S的变位词，对两个字符串进行排序将产生两个相同的字符串。
//时间复杂度：O(n log n)；空间复杂度O(1)。
class solution1{
    public boolean isAnagram(final String s,final String t) {
    if (s.length()!=t.length()){
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
    }
}

//2.哈希表
//思路：计算两个字符串中每个字母的出现次数并进行比较。A-Z的26位计数器表。用一个计数器表计算s字母的频率，用t减少计数器表中的每个字母的计数器，然后检查计数器是否会到零。
//时间复杂度：O(n)；空间复杂度O(1)。
class solution2{
    public boolean isAnagram(String s,String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] counter = new int[26];
        for(int i = 0 ;i<s.length();i++){
            /*
            s.charAt(index)是取出字符串s中的第index+1个字符 
            这里的-'a'代表的是减去ASC11码表里面的数值 
            a的ascll码是97 
            字符的计算是首先转换成对应的ASC11码在计算 
            最后转换成 char类型 
            可以用(int)'a'强转查看ASC11码值
            */
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        //遍历数组
        for(int count : counter){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
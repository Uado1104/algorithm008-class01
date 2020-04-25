package Week_02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

java.util.HashMap;
/*
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
示例 1:
s = "abc", t = "ahbgdc"
返回 true.
示例 2:
s = "axc", t = "ahbgdc"
返回 false.
*/

public class isSubsequence392 {
    private static void main(String args[]) {
        String s = { 1, 2, 3, 4 };
        String t = { 2, 3, 4 };
        solution1 a = new intersect(s, t);
        return a;
    }
}

class solution1 {
    public boolean isSubsequence(String s, String t) {
        Stack<Character> Stack =new Stack<>();
        if(s== null||s.length()==0){
            return true;
        }else if(t==null){
            return false;
        }else{
            for(int i=s.length()-1;i>0;i--){
                Stack.add(s.charAt(i));
            }
            for(int i = 0 ;i<t.length();i++){
                if(t.charAt(i)==Stack.peek()){Stack.pop();}
                else{;}
            }
            return Stack.isEmpty();
        }
    }
}
//1.将遍历并s存入栈中
//2.判断例外
//3.逆向遍历t字符串并不断配对
//4.栈空则返回true



class solution2 {
    public boolean isSubsequence(String s, String t) {
        char[] arr = s.toCharArray();
        int j = -1;
        for (int i = 0;i<arr.length;i++){
            j = t.indexOf(arr[i],j+1);
            if(j==-1){
                return false;
            }
        }
        return true;
    }
}
//1.将s转换为数组
//2.遍历该数组
//3.将indexOf(char c,int m)赋予j,意思是从第m位置开始寻找该索引，找到则返回该索引，否则返回-1，利用该特性我们通过对索引处理从而获得解。
//4.当j为不为-1时，true
class solution2 {
    public boolean isSubsequence(String s, String t) {
        char[] arr = s.toCharArray();
        int j=-1;
        for(int i = 0;i<arr.length();i++){
            j = t.indexOf(arr[i],j+1);
            if(j == -1){
                return false;
            }
        }
        return true;
    }
}
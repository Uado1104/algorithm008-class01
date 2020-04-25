package Week_02;
import java.util.HashMap;
/*
题目：给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1：
输入: pattern = "abba", str = "dog cat cat dog"
输出: true

*/
public class wordPattern290 {
    private static void main(String args[]) {
        String s = "1234";
        String t = "2345";
        solution1 a = new wordPattern(s,t) ;
        return a;
    }
}

class solution1{
    public boolean wordPattern(String pattern, String str) {
        String[] array1 = str.split(" ");
        if (array1.length != pattern.length()) {
            return false;
        }
        String[] array2 = pattern.split("");
        return wordPatternHelper(array1, array2) && wordPatternHelper(array2, array1);
    }
    private boolean wordPatternHelper(String[] array1, String[] array2) {
        HashMap<String, String> map = new HashMap<>(); 
        for (int i = 0; i < array1.length; i++) {
            String key = array1[i];
            if (map.containsKey(key)) {
                if (!map.get(key).equals(array2[i])) {
                    return false;
                }
            } else {
                map.put(key, array2[i]);
            }
        }
        return true;
    }
}
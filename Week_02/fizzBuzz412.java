package Week_02;

import java.util.ArrayList;
import java.util.List;

/*
题目：写一个程序，输出从 1 到 n 数字的字符串表示。
1. 如果 n 是3的倍数，输出“Fizz”；
2. 如果 n 是5的倍数，输出“Buzz”；
3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
示例：
n = 15,
返回:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

*/
public class fizzBuzz412 {
    private static void main(String args[]) {
        solution1 a = new fizzBuzz(3);
        return a;
    }
}

// 时间复杂度：
// 空间复杂度：
class solution1 {
    public List<String> fizzBuzz(int n) {
        List<String> output = new ArrayList<String>();
        for (int i = 1; i < n + 1; i++) {
            boolean dividedBy3 = (i % 3 == 0);
            boolean dividedBy5 = (i % 5 == 0);

            String numOutputStr = "";
            if(dividedBy3){
                numOutputStr += "Fizz";
            }
            if(dividedBy5){
                numOutputStr +="Buzz";
            }
            if(numOutputStr.equals("")){
                numOutputStr += Integer.toString(i);
            }
            output.add(numOutputStr);
        }
        return output;
    }
}
package Week_03;
/*
题目：假一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。
与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，
请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。如果无法实现目标变化，请返回 -1。
注意:
起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
所有的目标基因序列必须是合法的。
假定起始基因序列与目标基因序列是不一样的。
示例 1:
start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]
返回值: 1
示例 2:
start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
返回值: 2
示例 3:
start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
返回值: 3

*/
import java.util.HashSet;

public class minMutation433 {
    public static void main (String[] args) {

    }
}

//斐波那契函数
//思路：F(n) = F(n-1) + F(n-2)
//
class Solution1 {
    //int类型的常量MAX_VALUE,它代表int所能表示的最大值 0x7FFFFFFF
    int minStepCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        //回溯dfs
        dfs(new HashSet<String> (), 0, start, end, bank);
        return (minStepCount == Integer.MAX_VALUE) ? -1 : minStepCount;
    }
    //自定义回溯方法
    private void dfs (HashSet<String> step, int stepCount,
                      String current, String end, String[] bank) {
        //回溯结束的终止条件，当起始和结束相等
        if (current.equals(end))
            minStepCount = Math.min(stepCount, minStepCount);
        //递归时的处理与计算，遍历bank中元素，选出元素差一的元素
        for (String str: bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++)
                if (current.charAt(i) != str.charAt(i))
                    if (++diff > 1) break;
        //向下递归,处理多余的元素
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }

}

class solution2{
    int minCount = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        //回溯dfs
        dfs(new HashSet<String>,0,start,end,bank);
        return (minCount == Integer.MAX_VALUE)?-1:minCount;

    }
    //递归回溯的终止条件
    private void dfs(HashSet<String> step,int stepCount,String current,String end,String[] bank){

        if(current.equals (end)){
            minCount = Math.min(Integer.MAX_VALUE,minCount);
        }
        //当前层处理信息
        for (String str: bank){
            int difference = 0;
            for(int i = 0;i<str.length ();i++) {
                if (current.charAt (i) != str.charAt (i)){
                    if(++difference>1) break;
                }
            }
            //向下一层，回收数据
            if(difference == 1){
                step.add (str);
                dfs (step,difference,current,end,bank);
                step.remove (str);
            }
        }
    }
    //向下一层，处理以前的数据
}
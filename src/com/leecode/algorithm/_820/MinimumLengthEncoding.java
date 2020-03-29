package com.leecode.algorithm._820;


import java.sql.SQLOutput;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 *
 *
 * 示例：
 *
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 	1 <= words.length <= 2000
 * 	1 <= words[i].length <= 7
 * 	每个单词都是小写字母 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/short-encoding-of-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumLengthEncoding {
    // 使用字典法
    public int minimumLengthEncoding(String[] words) {
        Tree root = new Tree();
        int sum=0;
        for (String word : words) {
            sum+=root.insert(word);
        }
        return sum;
    }

    static class Tree{
        Tree[] sonT = new Tree[26];
        public int insert(String s){
            Tree son = this;
            int count=0;
            char[] cs = s.toCharArray();
            for (int i = cs.length-1; i > -1; i--) {
                Tree t = son.sonT[cs[i]-'a'];
                if(t==null){
                    t = new Tree();
                    son.sonT[cs[i]-'a']=t;
                    count++;
                }
                son=t;
            }
            return count;
        }
    }

    // 自己写法
//    public int minimumLengthEncoding(String[] words) {
//        char[] cs = new char[words.length];
//        int sumLength=0;
//        for (int i = 0; i < words.length; i++) {
//            cs[i]=words[i].charAt(words[i].length()-1);
//            sumLength+=words[i].length()+1;
//        }
//        char[] longChar, shortChar;
//        int[] continues = new int[words.length];
//        boolean eq;
//        for (int i = 0; i < cs.length; i++) {
//            if(continues[i] == 1){
//                continue;
//            }
//            eq = false;
//            for (int j = i+1; j < cs.length; j++) {
//                if(continues[j] == 1){
//                    continue;
//                }
//                if(cs[i] == cs[j]){
//                    if(words[i].length() > words[j].length()){
//                        longChar=words[i].toCharArray();
//                        shortChar=words[j].toCharArray();
//                    }else {
//                        shortChar=words[i].toCharArray();
//                        longChar=words[j].toCharArray();
//                    }
//                    int s = shortChar.length-1, l = longChar.length-1;
//                    for (; s > -1 && shortChar[s] == longChar[l]; l--,s--);
//                    if(s == -1 && (!eq || l==-1)){
//                        sumLength=sumLength-shortChar.length-1;
//                        continues[j]=1;
//                        eq=true;
//                    }
//                }
//            }
//        }
//
//        return sumLength;
//    }

    public static void main(String[] args) {
        String[] words = {"time", "time", "time", "time"};
        System.out.println(new MinimumLengthEncoding().minimumLengthEncoding(words));
    }

}

package com.leecode.algorithm._365;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * 你允许：
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 */
public class CanMeasureWater {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x == z || z == y || z == 0 || z == x+y){
            return true;
        }else if(z > x+y){
            return false;
        }else if(x==1 || y==1){
            return true;
        }else if(x%2==0 && y%2==0 && z%2==1){
            return false;
        }else if(x==0){
            return z==y;
        }else if(y==0){
            return z==x;
        }
        int tempX=-1;
        while(tempX!=0){
            tempX=x%y;
            x=y;
            y=tempX;
        }
        return z%x==0;
    }

    public static void main(String[] args) {
        int x=22003, y=31237, z=123;
        System.out.println(new CanMeasureWater().canMeasureWater(x, y, z));
    }
}

package com.leecode.algorithm._1162;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 *
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 *
 *
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *
 *
 *
 *
 * 提示：
 *
 *
 * 	1 <= grid.length == grid[0].length <= 100
 * 	grid[i][j] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        Node root = new Node(0,0);
        Node next = null;
        int length=0;
        int gridLength = grid.length;
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                if(grid[i][j] == 1){
                    Node n = new Node(i,j);
                    if(next==null){
                        next=n;
                        root.next=n;
                    }else {
                        next.next=n;
                        next=n;
                    }
                    length++;
                }
            }
        }
        if(length == 0 || length == grid.length*grid[0].length){
            return -1;
        }

        while((root=root.next) != null){
            boolean isAdd=false;
            length=root.val+1;
            if(gridLength > root.x+1 && grid[root.x+1][root.y] == 0){
                grid[root.x+1][root.y] = length;
                next.next=new Node(root.x+1, root.y, length);
                next=next.next;
                isAdd=true;
            }
            if(gridLength > root.y+1 && grid[root.x][root.y+1] == 0){
                grid[root.x][root.y+1] = length;
                next.next=new Node(root.x, root.y+1, length);
                next=next.next;
                isAdd=true;
            }
            if(root.x-1 > -1 && grid[root.x-1][root.y] == 0){
                grid[root.x-1][root.y] = length;
                next.next=new Node(root.x-1, root.y, length);
                next=next.next;
                isAdd=true;
            }
            if(root.y-1 > -1 && grid[root.x][root.y-1] == 0){
                grid[root.x][root.y-1] = length;
                next.next=new Node(root.x, root.y-1, length);
                next=next.next;
                isAdd=true;
            }
            if(!isAdd){
                length--;
            }
        }
        return length;
    }

    static class Node{
        int x;
        int y;
        int val=0;
        Node next;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
        Node(int x, int y, int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
        MaxDistance maxDistance = new MaxDistance();
        System.out.println(maxDistance.maxDistance(grid));
    }
}

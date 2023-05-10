package hard;

import java.util.PriorityQueue;

public class Item1263 {

    /*
         推箱子
     */
    public int minPushBox(char[][] grid) {

        int rlen = grid.length;
        int llen = grid[0].length;
        //O(MN) 查找 箱子和人物的位置
        int px = 0, py = 0, bx = 0, by = 0;
        for(int i = 0; i < rlen; i++){
            for(int j = 0; j < llen; j++){
                if(grid[i][j] == 'S'){
                    px = i;
                    py = j;
                }
                if(grid[i][j] == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }

        //visited[i][j][m][n] = true 表示 人物在 (i, j) 坐标和 箱子在 (m, n) 坐标 这个状态已经访问过了
        boolean[][][][] visited = new boolean[rlen][llen][rlen][llen];
        /*
        当人物在箱子的左边时，人物可以选择向右边走
        当人物在箱子的右边时，人物可以选择向左边走
        当人物在箱子的上边时，人物可以选择向下边走
        当人物在箱子的下边时，人物可以选择向上边走
        这样才能保证步数最少，否则，如果箱子在左边，人物还向着右边走，那么就距离箱子越来越远，这是毫无意义的步数

        无法满足条件的情况：
        如果箱子会自己走的话，那么简单的 bfs 就能够完成了，但是这里需要人物来推动箱子
        这意味着箱子可能虽然旁边就是终点，但是可能不存在能够容纳人物的地方来推动箱子
        比如 下图，虽然 箱子 B 旁边就是终点 T，如果它能够自己走的话直接一步到终点
        但是由于需要推动，而却不存在容纳人物 S 的位置来 箱子 B 到达终点 T
        # # # #
        # T B #
        # . S #

        什么时候箱子的位置会发生改变？
        当人物向上下两个方向走的时候，如果人物的下一个位置就是箱子的位置，
        那么相当于顶着箱子前进，那么箱子同时也要往前进

        因为人物的移动不算在步数里的，因此可能移动的时候当前箱子推的步数很大，比如示例 1 ，人物绕了一大圈
        如果最优的情况，即最少的推箱子步数就是这绕一大圈的，但是别的状态还在推箱子，它能够更快的到达终点，但是推箱子步数很大
        所以最先碰到终点的不一定是步数最少的，所以需要使用一个优先队列
        */
        int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.step - b.step);
        queue.add(new Node(px, py, bx, by, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Node node = queue.poll();
                if(grid[node.bx][node.by] == 'T'){
                    return node.step;
                }
                //往四个方向走
                for(int[] p : pos){
                    int newPx = node.px + p[0];
                    int newPy = node.py + p[1];
                    int newBx = node.bx;
                    int newBy = node.by;
                    int newStep = node.step;
                    //人物的前进位置刚好是箱子的位置，那么箱子的位置也要发生改变
                    if(newPx == node.bx && newPy == node.by){
                        newBx += p[0];
                        newBy += p[1];
                        //箱子动了，步数 +1
                        newStep++;
                    }
                    //越界或者在障碍物上，那么跳过
                    if(newPx < 0 || newPx == rlen || newPy < 0 || newPy == llen
                            || newBx < 0 || newBx == rlen || newBy < 0 || newBy == llen
                            || grid[newPx][newPy] == '#' || grid[newBx][newBy] == '#'){
                        continue;
                    }
                    if(!visited[newPx][newPy][newBx][newBy]){
                        visited[newPx][newPy][newBx][newBy] = true;
                        queue.add(new Node(newPx, newPy, newBx, newBy, newStep));
                    }
                }
            }
        }
        return -1;
    }
    class Node{
        //人物坐标
        int px;
        int py;
        //箱子坐标
        int bx;
        int by;
        /*
        当前状态的步数，这里需要该变量是因为人物走动无需计算步数，而无意义的推箱子却可能计算步数，
        为了防止无意义的推箱子导致作为结果的步数增加，因此每个状态都需要存储各自的步数
        */
        int step;
        public Node(int px, int py, int bx, int by, int step){
            this.px = px;
            this.py = py;
            this.bx = bx;
            this.by = by;
            this.step = step;
        }
    }

}

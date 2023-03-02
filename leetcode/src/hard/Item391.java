package hard;

import java.util.*;

public class Item391 {

    /*
    完美矩形

    给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。
    这个矩形的左下顶点是 (xi, yi) ，右上顶点是 (ai, bi) 。

如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
     */

    public boolean isRectangleCover(int[][] rectangles) {
        // 完美矩形的左下角和右上角坐标
        int X1 = Integer.MAX_VALUE, Y1 = Integer.MAX_VALUE;
        int X2 = Integer.MIN_VALUE, Y2 = Integer.MIN_VALUE;

        // 小矩形面积之和
        int areas = 0;
        // 记录所有顶点的出现情况
        Set<String> points = new HashSet<>();
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
            // 更新坐标
            X1 = Math.min(x1, X1);
            Y1 = Math.min(y1, Y1);
            X2 = Math.max(x2, X2);
            Y2 = Math.max(y2, Y2);

            areas += (x2 - x1) * (y2 - y1);
            // 判断顶点是否出现过
            String[] ps = {x1 + " " + y1, x2 + " " + y2, x1 + " " + y2, x2 + " " + y1};
            for (String s : ps) {
                // 没有出现过，添加；否则，移除
                if(points.contains(s)){
                    points.remove(s);
                } else {
                    points.add(s);
                }
            }
        }

        // 面积是否相等
        int expected = (X2 - X1) * (Y2 -Y1);
        if(areas != expected){
            return false;
        }
        // 顶点情况是否满足
        if(points.size() != 4 || !points.contains(X1 + " " + Y1) || !points.contains(X2 + " " + Y2) || !points.contains(X1 + " " + Y2) || !points.contains(X2 + " " + Y1)){
            return false;
        }
        return true;
    }

    /*
    扫描线算法

    先将所有矩形的竖边都整理出来，以四元组的方式存储，[x1,y1,y2,1], [x2,y1,y2,-1]
    遍历所有的竖边，把边缘边，和聚在一起的非边缘边找出来判断：
        对于完美矩形的每一条非边缘的边，都成对出现（存在两条完全相同的左边和右边重叠）
        对于完美矩形的两条边缘竖边，均独立为一条连续的边
     */
    public boolean isRectangleCover2(int[][] rectangles){
        int n = rectangles.length*2;
        int[][] rs = new int[n][4];
        /*
        [x1,y1,y2,1][x2,y1,y2,-1]
        这类四元组表示的是[此竖边的横坐标，竖边的下纵坐标，竖边的上纵坐标，表示此竖边为所在矩形的左边/右边(-1/1)]
         */
        int idx = 0;
        for (int[] re : rectangles){
            // 左竖边
            rs[idx++] = new int[]{re[0],re[1],re[3],1};
            // 右竖边
            rs[idx++] = new int[]{re[2],re[1],re[3],-1};
        }
        Arrays.sort(rs,(a,b) ->{
            return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
        });

        for (int i = 0; i<n;){
            List<int[]> l = new ArrayList<>();
            List<int[]> r = new ArrayList<>();
            boolean flag = i == 0;
            int edge = i;
            while(edge < n && rs[i][0] == rs[edge][0]){
                edge++;
            }
            while (i < edge){
                List<int[]> list = rs[i][3] == 1 ? l:r;
                if (list.isEmpty()){
                    list.add(rs[i++]);
                }else{
                    int[] pre = list.get(list.size() - 1);
                    int[] cur = rs[i++];
                    if (pre[2] > cur[1]){
                        return false;
                    }else if (pre[2] == cur[1]){
                        pre[2] = cur[2];
                    }else {
                        list.add(cur);
                    }
                }
            }

            if (edge == n || flag){
                if (l.size() + r.size() != 1){
                    return false;
                }
            }else {
                if (l.size() != r.size()){
                    return false;
                }
                for (int j = 0; j<l.size();j++){
                    if (l.get(j)[1] == r.get(j)[1] && l.get(j)[2] == r.get(j)[2]){
                        continue;
                    }
                    return false;
                }
            }
        }
        return true;
    }

}

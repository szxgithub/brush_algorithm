package od2023.twohundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main25 {

    /*
    上班之路

    地图由以下元素组成：
        “.“ ：空地
        "*"：路障
        ”S“：jungle的家
        ”T“： 公司

    输入描述：
        输入第一行为两个整数 t、c， t代表拐弯的次数， c代表可以清除的路障个数
        输入的第二行为两个整数n,m  代表地图的大小
        接下来是n行包含m个字符的地图，
    输出描述：
        是否可以从家里出发到公司，是则输出YES，不能则输出NO

输入：
2 0
5 5
..S..
****.
T....
*****
.....
输出：
YES

     */



    public static char[][] map;     //地图
    public static int t;    //转弯次数
    public static int c;    //路障个数
    public static int n;    //地图行数
    public static int m;    //地图列数

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        c = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new char[n][m];
        char[][] mapCopy = new char[n][m];

        // 家的位置
        int x = 0;
        int y = 0;

        for(int i=0; i<n; i++){
            String string = sc.nextLine();
            for(int j=0; j<m; j++){
                map[i][j] = string.charAt(j);
                mapCopy[i][j] = map[i][j];
                // 找到jungle家的坐标
                if(map[i][j] == 'S'){
                    x = i;
                    y = j;
                }
            }
        }

        if(toCompany( mapCopy, x, y, new ArrayList<>(), 0, 0) == 1){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }

    /**
     * 深度优先搜索DFS算法
     *
     * @param newMap        地图，用来记录走过的行程
     * @param x             横坐标
     * @param y             纵坐标
     * @param list          走过的坐标集合
     * @param turn          转弯的次数
     * @param barricade     路过路障的次数
     * @return
     */
    public static int toCompany(char[][] newMap, int x, int y, List<int[]> list, int turn, int barricade){

        if(list.size() > 1){    //至少走过两个格子才能判断是否转弯
            int[] ints = list.get(list.size()-2);   //获取路过的倒数第二个格子
            if(ints[0] != x && ints[1] != y){   //如果横纵坐标都没有相同的，则表示转过弯
                turn ++;
            }
        }

        list.add(new int[]{x, y});      //走过的格子

        if(turn > t){       //转弯次数大于t，则不符合，返回
            return 0;
        }

        if(newMap[x][y] == '*'){    //记录路障的个数
            barricade ++;
        }

        if(barricade > c){      //路障的个数大于c，则不符合，返回
            return 0;
        }

        if(newMap[x][y] == 'T'){    //到达公司完成路程
            return 1;
        }

        newMap[x][y] = 'X';     //走过的地方记录为X

        if(x>0){    //向上
            if(newMap[x-1][y] != 'X'){      //走过的格子不再走
                if(toCompany( newMap,x-1, y, list, turn, barricade) == 1){
                    return 1;
                }else {
                    newMap[x-1][y] = map[x-1][y];   //不符合要求的路程需要恢复
                    list.remove(list.size()-1);     //走过的格子需要剔除
                }
            }
        }

        if(x<n-1){      //向下
            if(newMap[x+1][y] != 'X'){      //走过的格子不再走
                if(toCompany( newMap,x+1, y, list, turn, barricade) == 1){
                    return 1;
                }else {
                    newMap[x+1][y] = map[x+1][y];   //不符合要求的路程需要恢复
                    list.remove(list.size()-1);     //走过的格子需要剔除
                }
            }
        }

        if(y>0){        //向左
            if(newMap[x][y-1] != 'X'){      //走过的格子不再走
                if(toCompany( newMap, x, y-1, list, turn, barricade) == 1){
                    return 1;
                }else {
                    newMap[x][y-1] = map[x][y-1];   //不符合要求的路程需要恢复
                    list.remove(list.size()-1);     //走过的格子需要剔除
                }
            }
        }

        if(y<m-1){      //向右
            if(newMap[x][y+1] != 'X'){      //走过的格子不再走
                if(toCompany( newMap, x, y+1, list, turn, barricade) == 1){
                    return 1;
                }else {
                    newMap[x][y+1] = map[x][y+1];   //不符合要求的路程需要恢复
                    list.remove(list.size()-1);     //走过的格子需要剔除
                }
            }
        }

        return 0;
    }

}

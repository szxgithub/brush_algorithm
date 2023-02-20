package od2022I;

import java.util.*;

public class Main35 {

    /**
     *
     * 构成正方形数量
     *
     * 输入N个互不相同的二维整数坐标，求这N个坐标可以构成的正方形数量。(内积为零的的两个向量垂直)
     *
     *
     *
     * */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<int[]> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            int[] ints = new int[2];
            ints[0] = sc.nextInt();
            ints[1] = sc.nextInt();
            list.add(ints);
        }
        int count = 0;
        int len = list.size();
        if(len>3){
            for(int i=0;i<len-3;i++){
                for(int j=i+1;j<len-2;j++){
                    for(int k=j+1;k<len-1;k++){
                        for(int l=k+1;l<len;l++){
                            if(isZFX(list.get(i),list.get(j),list.get(k),list.get(l))){
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);

    }

    public static boolean isZFX(int[] a,int[] b,int[] c,int[] d){

        List<int[]> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        Map<Integer,Integer> map = new HashMap<>();
        int temp = 0;
        for(int i=0;i<3;i++){
            for(int j=i+1;j<4;j++){
                int x = list.get(i)[0]-list.get(j)[0];
                int y = list.get(i)[1]-list.get(j)[1];
                int len = x*x + y*y;    //求四个坐标六个向量的长度
                temp = len;
                map.put(len,map.getOrDefault(len,0)+1);
            }
        }

        if(map.size()==2 && (map.get(temp)==2 || map.get(temp)==4)){    //六条向量有四条相等且另外两条也相等则构成正方形
            return true;
        }

        return false;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }



    static int count = 0;
    public static void main2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Point[] arr = new Point[n];
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            Point point = new Point(x, y);
            arr[i] = point;
        }

        boolean[] flag = new boolean[n];
        dfs(flag, arr, new Stack<Point>(), 0);
        System.out.println(count);

    }

    private static void dfs(boolean[] flag, Point[] arr, Stack<Point> stack, int j) {
        if (stack.size() == 4){
            if (valid(stack)){
                count++;
            }
            return;
        }

        for (int i = 0; i < arr.length;  i++){
            if (i < j){
                continue;
            }

            if (flag[i]){
                continue;
            }

            stack.push(arr[i]);
            flag[i] = true;
            dfs(flag,arr,stack,i);
            flag[i] = false;
            stack.pop();
        }
    }

    private static boolean valid(Stack<Point> stack) {

       int  num = 0;
       Stack<Point> p = new Stack<>();
       p.addAll(stack);

        Point pop = p.pop();
        p.remove(pop);
        int[] len = new int[3];
        int j = 0;
        int n = 0;

        while (p.size() != 0){
            Point point = p.pop();
            len[j] = (pop.x- point.x)*(pop.x- point.x) + (pop.y - point.y)*(pop.y - point.y);
            j++;
        }
        //判断如果有两条领边及其两条领边的对角线能够构成等腰直角三角形则为正方形
        if (len[0] + len[1] == len[2] && len[0] == len[1] || len[1] + len[2] == len[0] && len[1] == len[2] || len[2] + len[0] == len[1] && len[2] == len[0]) {
            n++;
        }
        if (n == 1){
            return true;
        }
        return false;
    }

}

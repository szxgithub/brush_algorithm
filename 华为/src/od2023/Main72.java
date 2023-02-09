package od2023;


import java.util.*;

public class Main72 {

    /*

    最多等和不相交连续子序列
    //todo
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] strings = sc.nextLine().split(" ");

        int[] ints = new int[N];

        for(int i=0; i<N; i++){
            ints[i] = Integer.valueOf(strings[i]);
        }

        /**
         * key：连续子序列和
         * value：子序列的首尾坐标数组
         */
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0; i<N; i++){
            int count = ints[i];
            for (int j=i; j<N; j++){
                int[] temp = { i, j};   //首坐标i，尾座标j
                if( i != j){    //单独的序列不需要进行求和
                    count += ints[j];
                }
                if(map.containsKey(count)){
                    map.get(count).add(temp);
                }else {
                    List<int[]> tempList = new ArrayList<>();
                    tempList.add(temp);
                    map.put( count, tempList);
                }
            }
        }

        int res = 0;
        for (List<int[]> list : map.values()){
            res = Math.max( res, removeIntersect(list));
        }

        System.out.println(res);
    }

    /**
     * 求出子序列中互不相交的最长子序列
     * @param list  和相同的子序列集合
     * @return      最长子序列的长度
     */
    public static int removeIntersect(List<int[]> list){

        int max = 0;
        for(int i=0; i<list.size(); i++){
            List<int[]> tempList = new ArrayList<>();
            tempList.add(list.get(i));
            int right = list.get(i)[1];     //第一个序列的最后一个元素下标
            for(int j=0; j<list.size(); j++){
                if(i != j){
                    int left = list.get(j)[0];
                    if(left > right) {  //没有交集
                        tempList.add(list.get(j));
                        right = list.get(j)[1];
                    }
                }
            }
            max = Math.max( max, tempList.size());
        }

        return max;
    }

}



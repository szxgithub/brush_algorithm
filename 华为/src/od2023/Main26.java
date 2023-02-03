package od2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main26 {

    /*

    AI处理器组合

     */

    public static List<Integer> first;    //第一个链路
    public static List<Integer> second;    //第二个链路
    public static int remainFirst;    //第一个链路的可用处理器个数
    public static int remainSecond;    //第二个链路的可用处理器个数
    public static List<List<Integer>> tempLists = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().replace("[","")
                .replace("]","")
                .split(",");
        int num = sc.nextInt();     //申请处理器的数量

        // 第一链路
        first = new ArrayList<>();
        // 第二链路
        second = new ArrayList<>();
        for(String s : strings){

            int i = Integer.valueOf(s.trim());
            if( i < 4){
                first.add(i);
            }else {
                second.add(i);
            }
        }
        remainFirst = first.size();
        remainSecond = second.size();

        if(num == 1){
            oneCpu();
        }else if(num == 2){
            twoCpu();
        }if(num == 4){
            if(remainFirst == 4){
                tempLists.add(Arrays.asList( 0, 1, 2, 3));
            }
            if(remainSecond == 4){
                tempLists.add(Arrays.asList( 4, 5, 6, 7));
            }
        }if(num == 8){
            if(remainSecond == 4 && remainSecond == 4){
                tempLists.add(Arrays.asList( 0, 1, 2, 3, 4, 5, 6, 7));
            }
        }

        System.out.println(tempLists.size() == 0 ? "[]" : tempLists);
    }

    /**
     *申请处理器个数为1
     * 则选择同一链路，剩余可用的处理器数量为1个的最佳
     * 其次是剩余3个的为次佳
     * 然后是剩余2个
     * 最后是剩余4个
     */
    public static void oneCpu(){

        List<List<Integer>> lists = new ArrayList<>();
        int[] ints = new int[]{ 1, 3, 2, 4};    //可用处理器数量的优先级
        boolean isFit = false;      //是否有了满足的链路

        for(int i : ints){
            if(i == remainFirst){
                lists.add(first);
                isFit = true;
            }
            if(i == remainSecond){
                lists.add(second);
                isFit = true;
            }
            if(isFit){
                break;
            }
        }

        for(int i=0; i<lists.size(); i++){
            handle( lists.get(i), new ArrayList<>(), 0, 1);
        }
    }

    /**
     * 申请处理器个数为2
     * 则选择同一链路,剩余可用的处理器数量2个的为最佳
     * 其次是剩余4个
     * 最后是剩余3个
     */
    public static void twoCpu(){

        List<List<Integer>> lists = new ArrayList<>();
        int[] ints = new int[]{ 2, 4, 3};   //可用处理器数量的优先级
        boolean isFit = false;  //是否有了满足的链路

        for(int i : ints){
            if(i == remainFirst){
                lists.add(first);
                isFit = true;
            }
            if(i == remainSecond){
                lists.add(second);
                isFit = true;
            }
            if(isFit){
                break;
            }
        }

        for(int i=0; i<lists.size(); i++){
            handle( lists.get(i), new ArrayList<>(), 0, 2);
        }

    }

    /**
     * 申请n个处理器的所有可能性
     * @param firstOrSecond 选中的链路
     * @param list          申请的处理器
     * @param index         处理器的索引
     * @param n             申请处理器的个数
     */
    public static void handle(List<Integer> firstOrSecond, List<Integer> list, int index, int n){

        if(list.size() == n){
            List<Integer> tempList = new ArrayList<>();
            tempList.addAll(list);
            tempLists.add(tempList);
        }else {
            for( int i=index; i<firstOrSecond.size(); i++){

                list.add(firstOrSecond.get(i));
                handle(firstOrSecond, list, i +1, n);
                list.remove(list.size()-1);
            }
        }

    }

}

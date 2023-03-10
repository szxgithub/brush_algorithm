package od2023.twohundred;

import java.util.*;
import java.util.stream.Collectors;

public class Main21 {

    /*
    最大数字

    给定一个由纯数字组成的以字符串表示的数值，要求字符串中重复的数字不超过2次，删除重复数字，其他相对不变
    返回经过删除操作后的最大的数值

    输入：
    54457955045
    输出：5479504

     */

    /*
    时间复杂度O（n）
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        List<Integer> list = new ArrayList<>();
        int[] record = new int[10];

        for (int i = 0; i < str.length(); i++) {
            int a = str.charAt(i) - '0';
            if(record[a] < 2){
                list.add(a);
                record[a]++;
            }else {
                int index1 = list.indexOf(a);
                int index2 = list.lastIndexOf(a);
                if(list.get(index1 + 1) > list.get(index1)){
                    list.remove(index1);
                    list.add(a);
                    continue;
                }
                if(index2 < list.size() - 1 && list.get(index2 + 1) > list.get(index2)){
                    list.remove(index2);
                    list.add(a);
                }
            }
        }

        String collect = list.stream().map(String::valueOf).collect(Collectors.joining());

        System.out.println(collect);

    }

    /*
    最优解思路，利用栈
     */
    public String getResult(String str){

        // 每个字符可用个数
        HashMap<Character,Integer> unused = new HashMap<>();
        // 每个数字字符的保留个数
        HashMap<Character,Integer> reserve = new HashMap<>();

        for (int i= 0; i < str.length(); i++){
            char c  = str.charAt(i);
            unused.put(c,unused.getOrDefault(c,0) + 1);
            reserve.putIfAbsent(c,0);
        }

        LinkedList<Character> stack = new LinkedList<>();

        for (int i=0; i < str.length(); i++){
            char c = str.charAt(i);
            if (reserve.get(c) == 2){
                unused.put(c,unused.get(c) - 1);
                continue;
            }

            while (stack.size() > 0){
                char top = stack.getLast();
                if (top < c && unused.get(top) + reserve.get(top) - 1 >= 2){
                    stack.removeLast();
                    reserve.put(top,reserve.get(top) - 1);
                }else {
                    break;
                }
            }

            stack.add(c);
            // 可用c数字个数--
            unused.put(c,unused.get(c) - 1);
            // 已经保留c数字个数++
            reserve.put(c,reserve.get(c) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack){
            sb.append(c);
        }
        return sb.toString();
    }

}

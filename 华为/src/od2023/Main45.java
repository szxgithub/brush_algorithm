package od2023;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

public class Main45 {

    /*

    优秀学员统计

    输入：
    11
    4 4 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2
    0 1 7 10
    0 1 6 10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    10
    6 10
    7 10
输出： 10 0 1 7 6



     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 新员工数量
        int N = Integer.parseInt(sc.nextLine());

        String[] s = sc.nextLine().split(" ");
        // 每天打卡的员工人数
        int[] nums = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        HashMap<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i<30; i++){
           for (int j= 0;j < nums[i]; j++){
               int id = sc.nextInt();
               if (map.containsKey(id)){
                   int[] ints = map.get(id);
                   ints[0]++;
               }else {
                   map.put(id,new int[]{1,i});
               }
           }
        }


        ArrayList<Map.Entry<Integer, int[]>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            if (o1.getValue()[0] > o2.getValue()[0]){
                return -1;
            }else if (o1.getValue()[0] < o2.getValue()[0]){
                return 1;
            }else {
                if (o1.getValue()[1] == o2.getValue()[1]){
                    return o1.getKey() - o2.getKey();
                }else {
                    return o1.getValue()[1] - o2.getValue()[1];
                }
            }
        });

        // 按顺序输出打卡次数top5员工的id
        String res = "";
        int count = 0;
        for (Map.Entry<Integer,int[]> entry: list){
            res += entry.getKey() + " ";
            count++;
            if (list.size() >= 5 && count == 5){
                break;
            }
        }
        System.out.print(res.substring(0,res.length()-1));

    }

}

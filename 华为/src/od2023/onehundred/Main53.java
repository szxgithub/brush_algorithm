package od2023.onehundred;

import java.util.*;

public class Main53 {

    /*

    优秀学员统计
    每个员工对应一个id，每天的打卡记录记录当天打卡员工的id集合，一共30天

    请你用代码统计出打卡次数top5的员工。
    若打卡次数相同，将较早参与打卡的员工排在前面，如果开始打卡的时间还是一样，将id较小的员工排在前面

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

    /*
    逻辑分析 排序
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 新员工数量
        int N = Integer.parseInt(sc.nextLine());

        // 每天打卡的员工人数
        String[] s = sc.nextLine().split(" ");
        int[] nums = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        HashMap<Integer,int[]> map = new HashMap<>();
        // 输入30天的每天打卡id
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

        // int[] 记录了每个id员工 打卡的统计次数和第一次打卡的天数
        ArrayList<Map.Entry<Integer, int[]>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            // 先按打卡次数降序排序
            if (o1.getValue()[0] > o2.getValue()[0]){
                return -1;
            }else if (o1.getValue()[0] < o2.getValue()[0]){
                return 1;
            }else {
                // 如打卡次数相同，再按打卡先后顺序排序
                if (o1.getValue()[1] == o2.getValue()[1]){
                    // 如打卡次数相同，打卡先后顺序相同，则按打卡id排序
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

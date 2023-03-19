package od2023.onehundred;

import java.util.*;
import java.util.stream.Collectors;

public class Main20 {
    /*
    关联端口组合并

    如果端口组间存在2个及以上不同端口相同，则认为这两个端口组互相关联，可以合并

    输入：
    6
    10
    4,2,1
    9
    3,6,9,2
    6,3,4
    8
输出：[[10], [1, 2, 3, 4, 6, 9], [9], [8]]

     */

    /*
    逻辑分析
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 1<= M <= 10
        int M = Integer.parseInt(sc.nextLine());

        if (M >10){
            System.out.println("[[]]");
            return;
        }

        List<TreeSet<Integer>> list = new ArrayList<>();
        for (int i =0; i < M; i++){
            String[] split = sc.nextLine().split(",");
            int[] ints = Arrays.stream(split).mapToInt(value -> Integer.valueOf(value)).toArray();
            List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
            TreeSet<Integer> set = new TreeSet<Integer>(collect);
            list.add(set);
        }

        // 遍历端口组
        for (int i =0; i<list.size(); i++){
            TreeSet<Integer> treeSet1 = list.get(i);
            for (int j = 0; j <list.size(); j++){
                if (list.get(j).size()<2){
                    continue;
                }
                if (j == i){
                    continue;
                }
                boolean isMerge = false;
                int count = 0;
                TreeSet<Integer> treeSet2 = list.get(j);
                for (Integer num : treeSet2){
                    if (treeSet1.contains(num)){
                        count++;
                    }
                    if (count >= 2){
                        isMerge = true;
                        break;
                    }
                }
                if (isMerge){
                    treeSet1.addAll(treeSet2);
                    list.remove(j);
                    // 从头开始再遍历 i++后为0
                    i = -1;
                    break;
                }
            }
        }

        System.out.println(list);

    }

}

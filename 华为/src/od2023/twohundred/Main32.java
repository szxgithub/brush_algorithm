package od2023.twohundred;

import java.util.*;

public class Main32 {

    /*

    九宫格
    九宫格游戏规则要求3x3的格子中，每行、每列以及两个对角线上的三数之和都等于15
    现在有一种新玩法，要求每行、每列以及对角线上的三数之积相等（三阶积幻方）

    输入描述：
        九个不同的数字，每个数字之间用空格隔开
    输出描述：
        九个数字所有满足要求的排列，每行输出一个满足要求的排列
        要求输出的排列升序排列

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        Integer[] arr = Arrays.stream(s).map(value -> Integer.valueOf(value)).toArray(Integer[]::new);

        getResult(arr);

    }

    /*
    基于回溯的全排列求解  对于本题一共有9格数字，9! = 362880个，数量级还好，可以暴力求解
     */
    private static void getResult(Integer[] arr) {

        boolean[] used = new boolean[arr.length];

        LinkedList<Integer> path = new LinkedList<>();
        ArrayList<Integer[]> res = new ArrayList<>();

        dfs(arr,used,path,res);

        res.sort((a,b) ->{
            for (int i = 0; i <9; i++){
                if (!Objects.equals(a[i],b[i])){
                    return a[i] - b[i];
                }
            }
            return 0;
        });

        for (Integer[] ele : res){
            StringJoiner sj = new StringJoiner(" ");
            for (Integer i : ele){
                sj.add(i + "");
            }
            System.out.println(sj);
        }

    }

    /**
     * 
     * @param arr  待排列的数组元素
     * @param used 标记哪些元素已经选择了
     * @param path 选择好的排列
     * @param res  满足要求的结果
     */
    private static void dfs(Integer[] arr, boolean[] used, LinkedList<Integer> path, ArrayList<Integer[]> res) {
        if (path.size() == arr.length){
            if (check(path)){
                Integer[] a = path.toArray(new Integer[0]);
                res.add(a);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++){
            if (!used[i]){
                path.add(arr[i]);
                used[i] = true;
                dfs(arr,used,path,res);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static boolean check(LinkedList<Integer> path){
        Integer[] a = path.toArray(new Integer[0]);
        int r1 = a[0]*a[1]*a[2];

        int r2 = a[3]*a[4]*a[5];
        if (r1 != r2) return false;

        int r3 = a[6]*a[7]*a[8];
        if (r1 != r3) return false;

        int c1 = a[0]*a[3]*a[6];
        if (r1 != c1) return false;

        int c2 = a[1]*a[4]*a[7];
        if (r1 != c2) return false;

        int c3 = a[2]*a[5]*a[8];
        if (r1 != c3) return false;

        int s1 = a[0]*a[4]*a[8];
        if (r1 != s1) return false;

        int s2 = a[2]*a[4]*a[6];
        if (r1 != s2) return false;

        return true;
    }


}

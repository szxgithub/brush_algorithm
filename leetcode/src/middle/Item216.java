package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Item216 {

    /*

    组合总和 III

    找出所有相加之和为n的k个数的组合

    条件：
    只能使用1-9
    每个数字最多使用一次

     */

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }


    public static void main(String[] args) {
        Item216 item216 = new Item216();
        int k  = 9;
        int n = 45;
        List<List<Integer>> lists = item216.combinationSum3(k, n);
        System.out.println(lists);
    }

}

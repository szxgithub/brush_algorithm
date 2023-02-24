package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item89 {

    /*

    格雷编码

    n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
    每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
    第一个整数是 0
    一个整数在序列中出现 不超过一次
    每对 相邻 整数的二进制表示 恰好一位不同 ，且
    第一个 和 最后一个 整数的二进制表示 恰好一位不同
    给你一个整数 n ，返回任一有效的 n 位格雷码序列 。

     */

    /*

    采用规律方法，通过对0、1、2、3、4位格雷码观察，可以发现规律

     */
    public List<Integer> grayCode(int n){

        List<Integer> result = new ArrayList<>();
        // 先将0加入
        result.add(0);
        if(n == 0){
            return result;
        }
        // 由于最高位前默认为 0 所以只需将当前result 按照倒叙输出并在每一个二进制前面加first即可
        int first = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--)
                result.add(first + result.get(j));
            // 左移一位  为了实现前缀加1
            first = first << 1;
        }
        return result;
    }

    public static void main(String[] args) {

        Item89 item89 = new Item89();
        List<Integer> integers = item89.grayCode(2);
        System.out.printf(Arrays.toString(integers.toArray()));

    }

}

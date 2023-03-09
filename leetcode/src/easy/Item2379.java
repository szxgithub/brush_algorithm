package easy;

public class Item2379 {

    /*
    得到 K 个黑块的最少涂色次数

     */

    /*
    暴力解法
     */
    public int minimumRecolors(String blocks, int k){
        int max = Integer.MAX_VALUE;
        for (int i = 0; i + k <= blocks.length(); i++){
            String substring = blocks.substring(i, i + k);
            int count = 0;
            for (int j = 0; j<substring.length(); j++){
                char c = substring.charAt(j);
                if (c == 'W'){
                    count++;
                }
            }
            max = Math.min(max,count);
        }
        return max;
    }

    /*
    滑动窗口解法
     */
    public int minimumRecolors2(String blocks, int k){
       /*
        定长滑窗:
        固定一个长度为k的窗口，统计窗口内W的个数最小值就是答案
         */
        int n = blocks.length(), w = 0;
        // 初始化首个窗口
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') w++;
        }
        int min = w;
        // 滑窗维护W个数最小值
        // 这里以即将进入窗口的元素索引为锚点，那么即将推出窗口的索引为j-k
        for (int j = k; j < n; j++) {
            int i = j - k;
            if (blocks.charAt(i) == 'W') w--;
            if (blocks.charAt(j) == 'W') w++;
            if (w < min) min = w;
        }
        return min;
    }

    public static void main(String[] args) {
        Item2379 item2379 = new Item2379();
        // String blocks = "WBBWWBBWBW";
        String blocks = "WBWBBBW";
        int k = 2;
        int i = item2379.minimumRecolors2(blocks, k);
        System.out.println(i);

    }

}

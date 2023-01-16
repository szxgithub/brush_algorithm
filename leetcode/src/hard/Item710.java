package hard;

import java.util.*;

public class Item710 {

    /**
     *
     * 黑名单中的随机数
     *
     * @param n
     * @param blacklist
     */

    Map<Integer, Integer> b2w;
    Random random;
    int bound;
    public Item710(int n, int[] blacklist){
        // 黑名单到白名单的映射
        b2w = new HashMap<Integer, Integer>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;

        // 存放[n-m,n)之间的黑名单
        Set<Integer> black = new HashSet<Integer>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }

        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (black.contains(w)) {
                    ++w;
                }
                b2w.put(b, w);
                ++w;
            }
        }
    }

    public int pick(){

        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }

    public static void main(String[] args) {

        int n = 2;
        int[] blacklist = new int[]{};

        Item710 item710 = new Item710(n,blacklist);
        int pick = item710.pick();
        System.out.println(pick);

    }


}

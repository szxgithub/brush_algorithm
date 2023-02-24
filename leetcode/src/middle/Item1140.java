package middle;

public class Item1140 {

    /*

    石子游戏 II

    许多石头排成一行，最初 M = 1
    在每个玩家的回合中，该玩家可以拿走剩下的前X堆的所有石子， 其中1 <= X <= 2M 然后令 M = max(M,x)

    求其中一位可以得到的最大数量的石头

     */

    //  https://leetcode.cn/problems/stone-game-ii/solutions/2125930/python3javacgo-yi-ti-yi-jie-qian-zhui-he-flo7/?orderBy=most_votes
    private int[] s;
    private Integer[][] f;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        s = new int[n + 1];
        f = new Integer[n][n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + piles[i];
        }
        return dfs(0, 1);
    }

    private int dfs(int i, int m) {
        if (m * 2 >= n - i) {
            return s[n] - s[i];
        }
        if (f[i][m] != null) {
            return f[i][m];
        }
        int res = 0;
        for (int x = 1; x <= m * 2; ++x) {
            res = Math.max(res, s[n] - s[i] - dfs(i + x, Math.max(m, x)));
        }
        return f[i][m] = res;
    }

}

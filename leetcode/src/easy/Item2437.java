package easy;

public class Item2437 {

    /*
    有效时间的数目
     */

    public int countTime(String time) {
        return count(time.substring(0, 2), 24) * count(time.substring(3), 60);
    }

    private int count(String time, int period) {
        char[] t = time.toCharArray();
        int ans = 0;
        for (int i = 0; i < period; i++)
            if ((t[0] == '?' || i / 10 == t[0] - '0') &&
                    (t[1] == '?' || i % 10 == t[1] - '0'))
                ans++;
        return ans;
    }

    /*
    暴力枚举
     */
    public int countTime2(String time){
        int ans = 0;
        for (int h = 0; h < 24; h++){
            for (int m = 0; m <60; m++){
                String s = String.format("%02d:%02d",h,m);
                int ok = 1;
                for (int i = 0; i <5; i++){
                    if (s.charAt(i) != time.charAt(i) && time.charAt(i) != '?'){
                        ok = 0;
                        break;
                    }
                }
                ans += ok;
            }
        }
        return ans;
    }
}

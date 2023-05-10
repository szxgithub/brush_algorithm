package middle;

public class Item1010 {

    /*
    总持续时间可被 60 整除的歌曲

     */

    /*
    暴力超时
     */
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        for (int i = 0; i < time.length; i++){
            for (int j = i + 1; j < time.length; j++){
                if ((time[i] + time[j])%60 == 0){
                    ans++;
                }
            }
        }
        return ans;
    }

    public int numPairsDivisibleBy602(int[] time) {
        int ans = 0;
        int[] cnt = new int[60];
        for (int t : time){
            int index = (60 - t % 60) % 60;
            ans += cnt[index];
            cnt[t%60]++;
        }
        return ans;
    }


    public static void main(String[] args) {
        Item1010 item1010 = new Item1010();
        // int[] time = {30,20,150,100,40};
        int[] time = {60,60,60};
        int i = item1010.numPairsDivisibleBy60(time);
        System.out.println(i);
    }

}

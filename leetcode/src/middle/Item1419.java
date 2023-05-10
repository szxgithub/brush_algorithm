package middle;

public class Item1419 {

    /*
    数青蛙
     */

    private static final char[] PREVIOUS = new char['s'];
    static {
        char[] s = "croakc".toCharArray();
        for (int i = 1; i < s.length; i++){
            PREVIOUS[s[i]] = s[i-1];
        }
    }
    public int minNumberOfFrogs(String croakOfFrogs){
        int[] cnt = new int['s'];
        for (char ch : croakOfFrogs.toCharArray()){
            char pre = PREVIOUS[ch];
            if (cnt[pre] > 0){
                cnt[pre]--;
            }else if (ch != 'c'){
                return -1;
            }
            cnt[ch]++;
        }
        if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0){
            return -1;
        }
        return cnt['k'];
    }

    public static void main(String[] args) {
        Item1419 item1419 = new Item1419();
        String croakOfFrogs = "croakcrook";
        int i = item1419.minNumberOfFrogs(croakOfFrogs);
        System.out.println(i);
    }

}

package middle;

public class Item1638 {

    /*
    统计只差一个字符的子串数目
     */

    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        int ans = 0;
        for (int i = 0; i <m;i++){
            for (int j = 0; j <n; j++){
                int diff = 0;
                for (int k = 0; i + k <m && j + k <n; k++){
                    diff += s.charAt(i + k) == t.charAt(j + k) ? 0 : 1;
                    if (diff > 1){
                        break;
                    }else if (diff == 1){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {



    }

}

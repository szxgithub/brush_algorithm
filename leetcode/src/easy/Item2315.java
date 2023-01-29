package easy;

public class Item2315 {

    /**
     *
     * 统计星号
     *
     *
     * */

    public int countAsterisks(String s){

        int ans = 0;

        int first = s.indexOf("|");
        if (first == -1){
            for (int i =0; i<s.length();i++){
                if (s.charAt(i) == '*'){
                    ans++;
                }
            }
            return ans;
        }

        for (int i = 0; i<first; i++){
            if (s.charAt(i) == '*'){
                ans++;
            }
        }

        int last = s.lastIndexOf("|");
        for (int i = last; i<s.length(); i++){
            if (s.charAt(i) == '*'){
                ans++;
            }
        }


        int left = first;
        int right = first;
        int count = 0;
        for (int i = first; i<=last; i++){
            char c = s.charAt(i);
            if (c == '|'){
                count++;
                if (count%2==0){
                    left = i+1;
                }else {
                    right = i;
                }
                if (right > left){
                    for (int j = left; j < right; j++){
                        if(s.charAt(j) == '*'){
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        Item2315 item2315 = new Item2315();

         String s = "*jsaxclgfcyjds";
        // String s = "iamprogrammer";
         // String s = "yo|uar|e**|b|e***au|tifu|l";
        // String s = "*||||**||*||**|**||*|||**";

        int i = item2315.countAsterisks(s);
        System.out.println(i);

    }

    public int countAsterisks2(String s) {
        boolean valid = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                valid = !valid;
            } else if (c == '*' && valid) {
                res++;
            }
        }
        return res;
    }

}

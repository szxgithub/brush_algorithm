package middle;

public class Item1616 {

    /*
    分割两个字符串得到回文串

     */

    /*
    暴力解法，超时 90/109
     */
    public boolean checkPalindromeFormation(String a, String b) {
        for (int i = 0; i< a.length(); i++){
            String aPrefix = a.substring(0, i);
            String aSuffix = a.substring(i, a.length());

            String bPrefix = b.substring(0, i);
            String bSuffix = b.substring(i, b.length());

            if ((aPrefix + bSuffix).length() == 1){
                return true;
            }
            if(check(aPrefix + bSuffix)){
                return true;
            }

            if ((bPrefix + aSuffix).length() == 1){
                return true;
            }
            if(check(bPrefix + aSuffix)){
                return true;
            }
        }
        return false;
    }

    private boolean check(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Item1616 item1616 = new Item1616();
        String a = "abdef";
        String b = "fecab";
        boolean b1 = item1616.checkPalindromeFormation(a, b);
        System.out.println(b1);
    }

    public boolean checkPalindromeFormation2(String a, String b) {

        return check(a,b) || check(b,a);

    }

    public boolean check(String a, String b){
        int i = 0, j = a.length()-1;
        while (i < j && a.charAt(i) == b.charAt(j)){
            ++i;
            --j;
        }
        return isPalindrome(a,i,j) || isPalindrome(b,i,j);
    }

    // 如果从 s[i] 到 s[j] 是回文串则返回 true，否则返回 false
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }


}

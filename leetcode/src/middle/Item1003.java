package middle;

public class Item1003 {

    /*
    检查替换后的词是否有效

     */
    public boolean isValid(String s){
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("abc") != -1){
            int index = sb.indexOf("abc");
             sb = sb.replace(index, index + 3, "");
        }
        if (sb.length() == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Item1003 item1003 = new Item1003();
        String s = "abccba";
        boolean valid = item1003.isValid(s);
        System.out.println(valid);
    }

}

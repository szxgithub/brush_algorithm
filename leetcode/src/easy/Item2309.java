package easy;

public class Item2309 {

    /**
     *
     * 兼具大小写的最好英文字母
     *
     * */

    public String greatestLetter(String s){

        String ans = "";

        int[] nums = new int[26];

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isLowerCase(c)){
                if (s.contains(Character.toUpperCase(c) + "")){
                    nums[c - 'a']++;
                }
            }else {
                if (s.contains(Character.toLowerCase(c) + "")){
                    nums[c - 'A']++;
                }
            }
        }

        for (int i = nums.length - 1; i >=0; i--){
            if (nums[i] != 0){
                return (char)('A' + i) + "";
            }
        }

        return ans;

    }

    public static void main(String[] args) {

        Item2309 item2309 = new Item2309();

        // String s = "lEeTcOdE";
        // String s = "arRAzFif";
        String s = "AbCdEfGhIjK";
        String s1 = item2309.greatestLetter(s);
        System.out.println(s1);

    }

}

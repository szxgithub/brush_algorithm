package easy;

public class Item2351 {

    public char repeatedCharacter(String s){
        int[] letter = new int[26];
        for (int i = 0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            if (letter[index] != 0){
                return s.charAt(i);
            }else {
                letter[index]++;
            }
        }
        return '\u0000';
    }

    public static void main(String[] args) {

        Item2351 item2351 = new Item2351();

        String  s = "abcdd";

        char c = item2351.repeatedCharacter(s);
        System.out.println(c);

    }

}

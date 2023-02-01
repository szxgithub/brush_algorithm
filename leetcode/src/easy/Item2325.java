package easy;

import java.util.HashMap;

public class Item2325 {

    /*
    解密消息
     */

    public String decodeMessage(String key, String message){

        HashMap<Character,Character> map = new HashMap<>();
        map.put(' ', ' '); // 把空格存进去就不用判断空格了，后续代码省事

        char[] array = key.toCharArray();
        char start = 'a';
        for (int i = 0; i< array.length; i++){
            if (map.containsKey(array[i])){
                continue;
            }else {
                map.put(array[i],start);
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++){
            sb.append(map.get(message.charAt(i)));
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        Item2325 item2325 = new Item2325();

        /*String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";*/

        String key = "eljuxhpwnyrdgtqkviszcfmabo";
        String message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb";

        String s = item2325.decodeMessage(key, message);
        System.out.println(s);

    }

}

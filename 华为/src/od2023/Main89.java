package od2023;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main89 {

    /*

    猜字谜

    输入：
    bdni,wooood
    bind,wrong,wood
    输出：
    bind,wood

     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String mimian = sc.nextLine();
        String midi = sc.nextLine();

        String[] split1 = mimian.split(",");
        String[] split2 = midi.split(",");

        StringBuffer sb = new StringBuffer();

        TreeSet<Character> treeSet = new TreeSet<>();
        for (int i = 0; i<split1.length; i++){
            String s1 = split1[i];
            char[] s1Arr = s1.toCharArray();
            for (int k = 0; k<s1Arr.length; k++){
                treeSet.add(s1Arr[k]);
            }
            String tmpS1 = treeSet.stream().map(character -> character.toString()).collect(Collectors.joining());
            treeSet.clear();

            for (int j = 0; j<split2.length; j++){
                String s2 = split2[j];
                if (s2.length() > s1.length()) {
                    continue;
                }else if (s2.length() < s1.length()){
                    char[] s2Arr = s2.toCharArray();
                    for (int k = 0; k<s2Arr.length; k++){
                        treeSet.add(s2Arr[k]);
                    }
                    if (treeSet.size() != tmpS1.length()){
                        treeSet.clear();
                        continue;
                    }
                    String tmpS2 = treeSet.stream().map(character -> character.toString()).collect(Collectors.joining());
                    treeSet.clear();
                    if (tmpS2.equals(tmpS1)){
                        sb.append(s2);
                        sb.append(",");
                    }
                }else{
                    char[] s2Arr = s2.toCharArray();
                    Arrays.sort(s2Arr);
                    String tmpS2 = String.valueOf(s2Arr);
                    if (tmpS2.equals(tmpS1)){
                        sb.append(s2);
                        sb.append(",");
                    }
                }
            }
        }

        if (sb.length() == 0){
            System.out.println("not found");
        }else {
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb);
        }
    }

}

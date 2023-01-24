package middle;

public class Item1813 {

    /**
     *
     * 句子相似性
     *
     * 示例 1：
     *
     * 输入：sentence1 = "My name is Haley", sentence2 = "My Haley"
     * 输出：true
     * 解释：可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
     *
     * */

    public boolean areSentencesSimilar(String sentence1, String sentence2){

        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        // i 表示两个字符串数组从左开始，最多有 i个字符串相同。j表示剩下的字符串数组从右开始
        int i = 0, j = 0;
        while (i < s1.length && i < s2.length && s1[i].equals(s2[i])){
            i++;
        }

        while (j < s1.length - i && j < s2.length - i && s1[s1.length - j - 1].equals(s2[s2.length - j - 1])){
            j++;
        }

        return i + j == Math.min(s1.length, s2.length);

    }

    public static void main(String[] args) {
        String s1 = "c h p Ny";
        String s2 = "c BDQ r h p Ny";
        Item1813 item1813 = new Item1813();
        boolean b = item1813.areSentencesSimilar(s1, s2);
        System.out.println(b);
    }

}

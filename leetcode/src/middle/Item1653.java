package middle;

public class Item1653 {

    /*
    使字符串平衡的最少删除次数
    可以删除s中任意数目的字符，使得s平衡，当不存在下标对i,j满足i<j，且s[i] = 'b' s[j]='a'时，认为s是平衡的
     */

    public int minimumDeletions(String s){

        char[] chars = s.toCharArray();
        int del = 0;

        // 统计a的个数
        for (char c : chars){
            del += 'b' - c;
        }

        int ans = del;
        for (char c : chars){
            del += (c - 'a')*2-1;
            ans = Math.min(ans,del);
        }
        return ans;
    }

    public static void main(String[] args) {
        Item1653 item1653 = new Item1653();
        String s = "bbaaaaabb";
        int i = item1653.minimumDeletions(s);
        System.out.println(i);
    }

}

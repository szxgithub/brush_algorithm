package easy;

public class Item191 {

    /*
    位1的个数
     */

    public int hanmingWeight(int n){
        int count = 0;
        while (n != 0){
            n = n&(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Item191 item191 = new Item191();
        // int n = 0b00000000000000000000000000001011;
        // int n = 0b00000000000000000000000010000000;
        int n = 0b11111111111111111111111111111101;
        int i = item191.hanmingWeight(n);
        System.out.println(i);
    }

}

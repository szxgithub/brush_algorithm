package easy;

public class Item231 {

    /*
    2 的幂
     */

    public boolean isPowerOfTwo(int n){
        if (n <= 0){
            return false;
        }
        return (n&(n-1)) == 0;
    }

    public static void main(String[] args) {

        Item231 item231 = new Item231();
        int n1 = 1;
        int n2 = 16;
        int n3 = 3;
        int n4 = 4;
        int n5 = 5;
        boolean powerOfTwo1 = item231.isPowerOfTwo(n1);
        boolean powerOfTwo2 = item231.isPowerOfTwo(n2);
        boolean powerOfTwo3 = item231.isPowerOfTwo(n3);
        boolean powerOfTwo4 = item231.isPowerOfTwo(n4);
        boolean powerOfTwo5 = item231.isPowerOfTwo(n5);
        System.out.println(powerOfTwo1);
        System.out.println(powerOfTwo2);
        System.out.println(powerOfTwo3);
        System.out.println(powerOfTwo4);
        System.out.println(powerOfTwo5);

    }

}

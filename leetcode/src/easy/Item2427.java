package easy;

public class Item2427 {

    /*
    公因子的数目
     */

    public int commonFactors(int a, int b) {
        int count = 0;
        for (int i = 1; i <= a && i <= b; i++){
            if (a%i == 0 && b%i== 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Item2427 item2427 = new Item2427();
        int a = 25, b = 30;
        int i = item2427.commonFactors(a, b);
        System.out.println(i);
    }

}

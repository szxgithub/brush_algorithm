package easy;

public class Item2413 {

    /*
    最小偶数
     */
    public int smallestEventMultiple(int n){
        int res = n;
        while (true){
            if (res%2 == 0 && res%n == 0){
                return res;
            }
            res++;
        }
    }

    public static void main(String[] args) {
        Item2413 item2413 = new Item2413();
        int n = 6;
        int i = item2413.smallestEventMultiple(n);
        System.out.println(i);
    }

}

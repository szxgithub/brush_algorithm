package middle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Item970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound){

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= bound;i*=x){
            for (int j = 1; i+j <= bound; j*=y){
                set.add(i + j);
                if (y == 1){
                    break;
                }
            }
            if (x == 1){
                break;
            }
        }
        return new ArrayList<>(set);

    }

    public static void main(String[] args) {
        Item970 item970 = new Item970();
        int x = 2, y = 1, bound = 10;
        List<Integer> list = item970.powerfulIntegers(x, y, bound);
        System.out.println(list);
    }

}

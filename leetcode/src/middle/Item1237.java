package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item1237 {

    /*

    找出给定方程的正整数解


     */

    public List<List<Integer>> findSolution(CustomFunction customFunction, int z){
        List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y > 0){
            int f = customFunction.f(x, y);
            if (f < z){
                x++;
            }else if (f > z){
                y--;
            }else {
                res.add(Arrays.asList(x++,y--));
            }
        }
        return res;
    }

    /*
    具体实现由系统给出
     */
    class CustomFunction{
        public int f(int x, int y){
            return 0;
        }
    }
}

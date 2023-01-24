package easy;

public class Item2303 {

    /*
    *
    * 计算应缴税款总额
    *
    *
    *
    * */

    public double calculateTax(int[][] brackets, int income){

        double res = 0;

        if (income == 0){
            return res;
        }

        for (int i = 0; i < brackets.length; i++){

            if (i == 0){
                if (income >= brackets[i][0]){
                    res += brackets[i][0]*brackets[i][1]/100d;
                    continue;
                }else {
                    res += income*brackets[i][1]/100d;
                    break;
                }
            }

            if ( i <= brackets.length -1 && income >= brackets[i][0]){
                res += (brackets[i][0] - brackets[i-1][0])*brackets[i][1]/100d;
            }else {
                res += (income- brackets[i-1][0])*brackets[i][1]/100d;
                break;
            }
        }

        return res;

    }

    public static void main(String[] args) {

        Item2303 item2303 = new Item2303();

        int[][] brackets = {{4,8},{5,49}};
        int income = 2;

        double v = item2303.calculateTax(brackets, income);
        System.out.println(v);

    }

}

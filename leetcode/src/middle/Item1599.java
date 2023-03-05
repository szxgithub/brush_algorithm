package middle;

public class Item1599 {

    /*

    经营摩天轮的最大利润


     */

    /**
     *
     * 模拟
     *
     * @param customers
     * @param boardingCost  登舱成本
     * @param runningCost  运行成本
     * @return  返回最大化利润所需执行的最小轮转次数， 如果不存在利润为正的方案，则返回-1
     */
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost){
        int online = 0;
        int wait = 0;
        int max  = 0;
        int profit = 0;
        int count = 0;
        int maxCount = -1;
        for (int i = 0; i<customers.length; i++){
            wait += customers[i];
            if (wait>4){
                online += 4;
                wait -= 4;
                profit = online * boardingCost - (++count) * runningCost;
            }else {
                online += customers[i];
                wait -= wait;
                profit = online * boardingCost - (++count) * runningCost;
            }
            if (profit > max){
                max = profit;
                maxCount = count;
            }
        }

        while (wait >0 && count != -1){
            if (wait > 4){
                online += 4;
            }else {
                online += wait;
            }
            wait -= 4;
            profit = online * boardingCost - (++count) * runningCost;
            if (profit > max){
                max = profit;
                maxCount = count;
            }
        }

        return maxCount;

    }

    public int minOperationsMaxProfit2(int[] customers, int boardingCost, int runningCost){
        int ans = -1;
        int mx = 0, t = 0;
        int wait = 0, i = 0;
        while (wait > 0 || i < customers.length){
            wait += i < customers.length ? customers[i] : 0;
            int up = Math.min(4,wait);
            wait -= up;
            ++i;
            t += up*boardingCost - runningCost;
            if (t > mx){
                mx = t;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Item1599 item1599 = new Item1599();
        int[] customers = {8,3};
        int boardingCost= 5;
        int runningCost = 6;
        int i = item1599.minOperationsMaxProfit(customers, boardingCost, runningCost);
        System.out.println(i);
    }

}

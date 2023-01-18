package hard;

import java.util.*;

public class Item1825 {

    /**
     *
     * 超出时间限制
     *
     */
    static class MKAverage{

        int m;
        int k;
        List<Integer> list = new ArrayList<>();
        public MKAverage(int m, int k){
            this.m = m;
            this.k = k;
        }

        public void addElement(int num){
            list.add(num);
        }

        public int calculateMKAverage(){
            if (list.size() < m){
                return -1;
            }
            List<Integer> newList = new ArrayList<>();
            for (int i = list.size() - 1; i > list.size() - m - 1; i--){
                newList.add(list.get(i));
            }
            Collections.sort(newList);
            for (int i = 0; i<k; i++){
                newList.remove(i);
            }
            int len = newList.size();
            for (int i = len - 1; i> len - k-1; i--){
                newList.remove(i);
            }

            double asDouble = newList.stream().mapToInt(Integer::intValue).average().getAsDouble();
            return (int) Math.floor(asDouble);

        }
    }

    static class MKAverage2 {
        long sum;//middle的和
        Queue<Integer> lower; //最小的k个数
        Queue<Integer> middleMin; //中间的数
        Queue<Integer> middleMax; //中间的数
        Queue<Integer> upper; //最大的k个数
        int m;
        int k;
        Queue<Integer> nums;
        public MKAverage2(int m, int k) {
            this.m = m;
            this.k = k;
            sum =0;
            lower = new PriorityQueue<>((u,v)->v-u); //大顶堆
            middleMin = new PriorityQueue<>(); //小顶堆
            middleMax = new PriorityQueue<>((u,v)->v-u); //大顶堆
            upper = new PriorityQueue<>(); //小顶堆
            nums = new LinkedList<>();
        }
        public void addElement(int num) {
            nums.offer(num);

            if(!lower.isEmpty() && lower.peek()>=num){
                lower.offer(num);
            }else if(!upper.isEmpty() && upper.peek()<=num){
                upper.offer(num);
            }else{
                middleMin.offer(num);
                middleMax.offer(num);
                sum += num;
            }

            while(lower.size()>k){
                int top = lower.poll();
                middleMin.offer(top);
                middleMax.offer(top);
                sum += top;
            }
            while(upper.size()>k){
                int down = upper.poll();
                middleMin.offer(down);
                middleMax.offer(down);
                sum += down;
            }

            if(nums.size()>m){
                int temp = nums.poll();
                if(lower.peek()>=temp){
                    lower.remove(temp);
                }else if(upper.peek()<=temp){
                    upper.remove(temp);
                }else{
                    middleMax.remove(temp);
                    middleMin.remove(temp);
                    sum -= temp;
                }
            }
            if(nums.size()>=m){
                while(lower.size()<k){
                    int temp = middleMin.poll();
                    middleMax.remove(temp);
                    sum -= temp;
                    lower.offer(temp);
                }
                while(upper.size()<k){
                    int temp = middleMax.poll();
                    middleMin.remove(temp);
                    sum -= temp;
                    upper.offer(temp);
                }
            }

        }

        public int calculateMKAverage() {
            if(nums.size()<m){
                return -1;
            }
            return (int)(sum/(m-2*k));
        }
    }

    public static void main(String[] args) {

        MKAverage2 mkAverage = new MKAverage2(6, 1);
        mkAverage.addElement(3);
        mkAverage.addElement(1);
        mkAverage.addElement(12);
        mkAverage.addElement(5);
        mkAverage.addElement(3);
        mkAverage.addElement(4);

        int i3 = mkAverage.calculateMKAverage();
        System.out.println(i3);


    }

}

package od;

import java.util.Scanner;

public class Main6 {

    /**
     *
     * IPv4地址转换成整数
     *
     * 存在一种虚拟IPv4地址
     *
     * 输入：
     * 128#0#255#255
     * 输出：
     * 2147549183（0x8000FFFF）
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){

            String str = sc.nextLine();

            String[] split = str.split("#");

            int[] nums = new int[split.length];

            for (int i = 0; i < nums.length; i++){
                nums[i] = Integer.parseInt(split[i]);
            }

            if (nums.length != 4){
                System.out.println("invalid IP");
                return;
            }

            if (
                    (nums[0] >= 1 && nums[0] <= 128) &&
                    (nums[1] >= 0 && nums[1] <= 255) &&
                    (nums[2] >= 0 && nums[2] <= 255) &&
                    (nums[3] >= 0 && nums[3] <= 255)
            ){

                String s0 = Integer.toHexString(nums[0]);
                String s1 = Integer.toHexString(nums[1]);
                String s2 = Integer.toHexString(nums[2]);
                String s3 = Integer.toHexString(nums[3]);

                if (s0.length() == 1){
                    s0 = "0" + s0;
                }
                if (s1.length() == 1){
                    s1 = "0" + s1;
                }
                if (s2.length() == 1){
                    s2 = "0" + s2;
                }
                if (s3.length() == 1){
                    s3 = "0" + s3;
                }


                String s = s0 + s1 + s2 + s3;
                long l = Long.parseUnsignedLong(s, 16);
                System.out.println(l);


            }else {
                System.out.println("invalid IP");
                return;
            }



        }

    }
}

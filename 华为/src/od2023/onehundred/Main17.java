package od2023.onehundred;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main17 {

    /*
    数组的中心位置

    数组的中心位置是数组的一个下标，其左侧所有元素相乘的积等于右侧所有元素相乘的积，数组中第一个元素的左侧积为1， 最后一个元素的右侧积为1

    如果数组有多个中心位置，返回最靠近左边的哪一个，如果不存在，则返回-1

    中心位置的值为数组的下标索引

     */

    public static void main2(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();

        String[] s = str.split(" ");
        int[] ints = Arrays.stream(s).mapToInt(value -> Integer.valueOf(value)).toArray();

        int leftMulti = 1;
        int rightMulti = 1;
        int left = 0;
        int right = ints.length-1;
        int res = 0;
        while (left <= right){
            if (leftMulti > rightMulti){
                rightMulti *= ints[right];
                right--;
            }else if (leftMulti < rightMulti){
                leftMulti *= ints[left];
                left++;
            }else {
                if (right != left){
                    res = -1;
                    rightMulti *= ints[right];
                    leftMulti *= ints[left];
                    right--;
                    left++;
                }else {
                    res = left;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    /*

    求左右两侧的前缀积
    再遍历数组，比较其左右两侧的前缀积相同，则输出其坐标
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        int len = strings.length;
        int[] nums = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        int[] leftProduct = new int[len];   //左侧前缀积
        leftProduct[0] = nums[0];
        for(int i=1; i<len; i++){
            leftProduct[i] = leftProduct[i-1] * nums[i];
        }

        int[] rightProduct = new int[len];  //右侧前缀积
        rightProduct[len-1] = nums[len-1];
        for(int i=len-2; i>=0; i--){
            rightProduct[i] = rightProduct[i+1] * nums[i];
        }

        int res = -1;
        if(rightProduct[1] == 1){   //根据题意，0的左侧积为1,如果右侧积也为1则中心位置为0
            res = 0;
        }else {
            for(int i=1; i<len; i++){
                if(i == len-1){
                    if(leftProduct[i-2] == 1){
                        res = len - 1;  //根据题意，len-1的右侧积为1,如果左侧积也为1则中心位置为len-1
                    }
                }else if(leftProduct[i-1] == rightProduct[i+1]){    //左侧积等于右侧积
                    res = i;
                    break;
                }
            }
        }
        System.out.println(res);
    }

    /*
    满分答案

    由于  1< nums.length < 1024   1<= nums[i] <=10
    也就是说单边积最大可以是10^1024， 这远远超过了int、long的范围
   应该用大数来处理
     */
    public int getResult(int[] nums){
        BigInteger fact = BigInteger.valueOf(1);
        for (Integer num : nums){
            fact = fact.multiply(BigInteger.valueOf(num));
        }

        BigInteger left = BigInteger.valueOf(1);
        BigInteger right = fact.divide(BigInteger.valueOf(nums[0]));

        if (left.compareTo(right) == 0){
            return 0;
        }

        for (int i = 1; i < nums.length; i++){
            left = left.multiply(BigInteger.valueOf(nums[i-1]));
            right = right.divide(BigInteger.valueOf(nums[i]));
            if (left.compareTo(right) == 0){
                return i;
            }
        }

        return -1;

    }

}

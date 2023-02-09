package od2023;

import java.util.Arrays;
import java.util.Scanner;

public class Main75 {

    /*
    数组的中心位置
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
                    continue;
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
}

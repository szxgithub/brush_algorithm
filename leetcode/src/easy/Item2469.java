package easy;

import java.util.Arrays;

public class Item2469 {

    /*
    温度转换

     */

    public double[] convertTemperature(double celsius) {

        double Kelvin = celsius + 273.15;
        double Fahrenheit = celsius * 1.80 + 32.00;

        return new double[]{Kelvin,Fahrenheit};
    }

    public static void main(String[] args) {
        Item2469 item2469 = new Item2469();

        double celsius = 36.50;
        double[] doubles = item2469.convertTemperature(celsius);
        System.out.println(Arrays.toString(doubles));
    }

}

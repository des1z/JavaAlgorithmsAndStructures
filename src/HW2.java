
/**
 * @version 29.11.2018
 * @author Viktor Chernyaev
 * @JavaAlgorithmsAndStructures homework Lesson-2
 * @link https://github.com/des1z
 */

public class HW2 {
    final static int n = 1000000;
    public static void main(String[] args) {
        int[] arr = new int[n];

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = ((int)(Math.random() * n));
            // System.out.println(arr[i]);            
        }
    }
}

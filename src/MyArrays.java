import java.util.Arrays;

public class MyArrays {
    public static int sum(int[] array) {

        int res = 0;

        for (int i = 0; i < array.length; i++) {
            res += array[i];
        }

        return res;
    }

    public static void zeroNegative(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0)
                array[i] = -array[i];
        }
    }

    public static int[] push(int[] array, int num) {

        int[] arr = new int[array.length+1];

        for (int i = 0; i < array.length; i++)
            arr[i] = array[i];

        arr[array.length] = num;
        return arr;
    }

    public static int[] add(int[] array, int index, int num) {

        int[] arr = new int[array.length+1];

        for (int i = 0, k = 0; i < array.length+1; i++) {
            if (i == index) {
                arr[i] = num;
                continue;
            }
            arr[i] = array[k];
            k++;
        }

        return arr;
    }
}

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        System.out.println(Arrays.toString(array));

        int[] array2 = MyArrays.push(array, 5);
        System.out.println(Arrays.toString(array2));

        int[] array3 = MyArrays.add(array2, 4, 31);
        System.out.println(Arrays.toString(array3));
    }
}
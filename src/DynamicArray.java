import java.util.Arrays;

public class DynamicArray {

    public int[] arr = new int[100];
    public int size = 0;

    public void add(int x, int index) {
        if (size == arr.length)
            arr = Arrays.copyOf(arr, arr.length * 2);


        for (int i = size; i > index; i--)
            arr[i] = arr[i - 1];

        arr[index] = x;
        size++;
    }

    public void add(int x) {
        if (size == arr.length)
            arr = Arrays.copyOf(arr, arr.length * 2);

        arr[size++] = x;
    }

    public String toString() {
        String res = "[";

        for (int i = 0; i < size-1; i++) {
            res += Integer.toString(arr[i]);
            res += ", ";
        }

        res += arr[size - 1];
        res += "]";

        return res;
    }

}

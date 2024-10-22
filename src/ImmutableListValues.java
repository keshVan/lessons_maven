import java.util.Arrays;

public class ImmutableListValues {
    private int[] array;

    public ImmutableListValues(int... nums) {
        this.array = Arrays.copyOf(nums, nums.length);
    }

    public ImmutableListValues(ImmutableListValues list) {
        this(list.getArray());
    }

    public int[] getArray() {
        return array;
    }

    public int get(int index) {
        checkIndex(index);
        return array[index];
    }

    public void replace(int index, int newNum) {
        checkIndex(index);
        array[index] = newNum;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    public int getSize() {
        return array.length;
    }

    public String toString() {
        String out = "[";

        for (int i = 0; i < array.length - 1; i++)
            out += array[i] + ", ";

        if (array.length > 0)
            out += array[array.length - 1];

        out += "]";
        return out;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > array.length - 1)
            throw new IllegalArgumentException("index out of bounds");
    }
}

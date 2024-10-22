import java.util.Arrays;

public class FixedListValues {
    private int[] array;
    private int size = 0;

    public FixedListValues() {
        this(100);
    }

    public FixedListValues(int size) {
        this.size = size;
    }

    public FixedListValues(FixedListValues list) {
        this.array = list.getArray();
        this.size = list.getSize();
    }

    public void add(int x, int index) {
        checkIndex(index);
        if (size == array.length)
            throw new IllegalArgumentException("list is full");


        for (int i = size; i > index; i--)
            array[i] = array[i - 1];

        array[index] = x;
        size++;
    }

    public void add(int x) {
        add(x, size);
    }

    public int[] getArray() {
        return Arrays.copyOf(array, size);
    }

    public int getSize() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("index out of bounds");
    }
}

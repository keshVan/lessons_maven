public class IllegalMarkException extends RuntimeException {
    private int illegalMark;

    public IllegalMarkException(int x) {
        super();
        this.illegalMark = x;
    }
}

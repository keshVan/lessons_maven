public class IllegalMarkException extends RuntimeException {
    private int illegalMark;

    public IllegalMarkException(int illegalMark) {
        super();
        this.illegalMark = illegalMark;
    }

    public IllegalMarkException(String s) {
        super(s);
    }

    public IllegalMarkException(Throwable cause) {
        super(cause);
    }
}

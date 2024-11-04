public class TimeAttribute extends Attribute{
    public TimeAttribute(String value) {
        super("Time", value);
    }

    @Override
    public String getValue() {
        return (String)super.getValue();
    }

    @Override
    public String toString() {
        return "в " + getValue();
    }
}

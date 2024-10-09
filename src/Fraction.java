public class Fraction {
    private final int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("denominator cannot be zero");
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction f) {
        if (denominator == f.denominator) return new Fraction(numerator + f.numerator, denominator);
        return new Fraction(numerator * f.denominator + f.numerator * denominator, denominator * f.denominator);
    }

    public Fraction sum(int num) {
        return sum(new Fraction(num, 1));
    }

    public Fraction minus(Fraction f) {
        if (denominator == f.denominator) return new Fraction(numerator - f.numerator, denominator);
        return new Fraction(numerator * f.denominator - f.numerator * denominator, denominator * f.denominator);
    }

    public Fraction minus(int num) {
        return minus(new Fraction(num, 1));
    }

    public Fraction mult(Fraction f) {
        return new Fraction(numerator * f.numerator, denominator * f.denominator);
    }

    public Fraction mult(int num) {
        return mult(new Fraction(num, 1));
    }

    public Fraction div(Fraction f) {
        return new Fraction(numerator * f.denominator, denominator * f.numerator);
    }

    public Fraction div(int num) {
        return div(new Fraction(num, 1));
    }
}

package lab5.task1;

import java.util.Objects;

public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator > 0) {
            this.denominator = denominator;
        } else if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        } else {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным");
        }
    }

    @Override
    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    public Fraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return numerator == ((Fraction) obj).numerator && denominator == ((Fraction) obj).denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}

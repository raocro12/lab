package lab5.task1;

import static java.util.Objects.hash;

public class FractionCached extends Fraction{

    private Double cachedValue;

    public void setCachedValue() {
        this.cachedValue =  getNumerator()/ (double)getDenominator();
    }

    public FractionCached(int numerator, int denominator) {
        super(numerator, denominator);
        cachedValue = null;
    }

    @Override
    //функция для вычисления вещественного значения
    public double toDouble(){
        if (this.cachedValue == null){
            setCachedValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int n){
        super.setNumerator(n);
        setCachedValue();
    }

    @Override
    public void setDenominator(int n){
        super.setDenominator(n);
        setCachedValue();
    }
}

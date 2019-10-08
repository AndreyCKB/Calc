package model.variables;

public abstract class Variable implements  Variables{
    protected static final ConvertorNumbers convertorNumbers = ConvertorNumbers.getInstance();
    protected int number;

    protected Variable(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Variables o) {
        return Integer.valueOf(number).compareTo(o.getNumber());
    }


}



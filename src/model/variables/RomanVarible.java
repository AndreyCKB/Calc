package model.variables;

public class RomanVarible extends Variable{
    private String romanNumber;

    public RomanVarible(String romanNumber) throws IllegalAccessException {
        super(convertorNumbers.convertRomNToArabN(romanNumber));
        this.romanNumber = romanNumber;
    }

    public RomanVarible(int number) throws IllegalAccessException {
        super(number);
        this.romanNumber =  convertorNumbers.convertArabNToRomN(number);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(number).hashCode() + this.romanNumber.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RomanVarible variable = (RomanVarible) o;
        return (number == variable.number && variableToString().equals(((RomanVarible) o).variableToString()));  }

    @Override
    public String variableToString() {
        return romanNumber;
    }

    @Override
    public Variables valueOf(int number) throws IllegalAccessException {
        return new RomanVarible(number);
    }

    @Override
    public Variables valueOf(String number) throws IllegalAccessException {
        return new RomanVarible(number);
    }


}

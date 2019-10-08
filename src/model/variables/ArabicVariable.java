package model.variables;

public class ArabicVariable extends Variable {

    public ArabicVariable(String arabicNumber){
        this(checkInputString(arabicNumber));
    }

    public ArabicVariable(int number) {
        super(number);
    }


    private static int checkInputString(String arabicNumber){
        try {
            return Integer.parseInt(arabicNumber);
        }catch (Exception e){}
        throw new IllegalArgumentException("Переданная строка [ " + arabicNumber +" ] не является Арабским числом");
    }

    @Override
    public String variableToString() {
        return  "" +number;
    }

    @Override
    public Variables valueOf(int number) {
        return new ArabicVariable(number);
    }

    @Override
    public Variables valueOf(String number) {
        return new ArabicVariable(number);
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(number).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArabicVariable variable = (ArabicVariable) o;
        return number == variable.number;  }

}

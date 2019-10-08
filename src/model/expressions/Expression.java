package model.expressions;

import model.variables.Variables;


public class Expression {
    private ActionOnVariable act;
    private Variables[] variables;
    private Variables calculatorResult;

    public Expression(ActionOnVariable actionOnVariable, Variables... variables) throws IllegalAccessException {
        checkInputData(actionOnVariable,variables);
        this.act = actionOnVariable;
        this.variables = variables;
        this.calculatorResult = calculated(actionOnVariable,variables);
    }

    private static void checkInputData(ActionOnVariable actionOnVariable, Variables... variables){
        if (variables.length > 2) throw new IllegalArgumentException("Введено не верное выражение");
        checkActionOnVariable(actionOnVariable);
        checkVariable(variables);

    }

    private static void checkActionOnVariable(ActionOnVariable action){
        if (action == null) throw new IllegalArgumentException("Введённая операция над данными не доступна");

    }

    private static void checkVariable(Variables... variables){
        Class<?> aClass = variables[0].getClass();
        for (Variables v : variables) {
            if (!v.getClass().equals(aClass))
                throw new IllegalArgumentException("Введёные переменные должны быть одного типа, только Арабские цифры или только Римские цифры");

            if (v.getNumber() < 1 || v.getNumber() > 10)
                throw new IllegalArgumentException("Введёные переменные должны быть в диапазоне от 1 до 10");
        }
    }

    private static Variables  calculated(ActionOnVariable actionOnVariable, Variables... variables) throws IllegalAccessException {
       int[] temp = new int[variables.length];
       for (int i = 0; i < temp.length; i++ )
            temp[i] = variables[i].getNumber();
       return variables[0].valueOf(actionOnVariable.execute(temp));
    }

    public Variables getCalculatedResult(){
        return this.calculatorResult;
    }

    private String arithmeticSign(){
        String result = "=";
        if (act != ActionOnVariable.DIVISION) return result;
        float temp = calculatorResult.getNumber() -  ((float)variables[0].getNumber() / (float)variables[1].getNumber());
        if ( temp != 0 ) result = "≈";
        return result;
    }

    @Override
    public String toString() {
        return  variables[0].variableToString() +
                " " + act.getSign() +
                " " + variables[1].variableToString() +
                " " + arithmeticSign() +
                " " + calculatorResult.variableToString();
    }
}

package model.expressions;

import model.variables.ArabicVariable;
import model.variables.RomanVarible;
import model.variables.Variable;

import java.util.*;

public class CreatExpressions implements Models{
    private static CreatExpressions instance = new CreatExpressions();
    private static final Set<Character>  AVAILEBLE_CHARACTERS =  new HashSet<>();
    static {
        for ( char c: "IXVCL 1234567890+-/*".toCharArray() )
            AVAILEBLE_CHARACTERS.add(c);
    }

    private CreatExpressions() {
    }

    public static CreatExpressions getInstance(){
       return instance;
    }

    
    public Expression getExpression(String inputLine) throws IllegalAccessException {
        ActionOnVariable act = null;
        Variable variable1,variable2;

        for (char c : inputLine.toCharArray()) {
            if (!AVAILEBLE_CHARACTERS.contains(c))
                throw new IllegalArgumentException("Введённая строка [ " + inputLine + " ] содержит недоступные символы");
            if ((act != null) && (findAct(c) != null))
                throw new IllegalAccessException("Введеная строка [ " + inputLine + " ] содержит более одного знака арифметической операции,  " +
                        "что является недопустимым выражением");
            if (findAct(c)!= null) act = findAct(c);

        }
        String[] strings = inputLine.split(act.getAct());
        variable1 = creatVariable(strings[0].trim());
        variable2 = creatVariable(strings[1].trim());
        return new Expression(act, variable1,variable2);    
    }

    
    private Variable creatVariable(String st) throws IllegalAccessException {
        Variable result = null;
        String exception = null;

        try {
            result = new ArabicVariable(st);
        } catch (Exception e){
            exception = e.getMessage();
        }

        if (result != null) return result;

        try {
            result = new RomanVarible(st);
        } catch (Exception e){
            exception = exception + "   " +e.getMessage();

        }
        if (result == null) throw new IllegalAccessException(exception);

        return result;

    }


    private ActionOnVariable findAct(char c){
        switch (c){
            case ('+') : return ActionOnVariable.SUM;
            case ('-') : return ActionOnVariable.SUBTRACTION;
            case ('*') : return ActionOnVariable.MULTIPLICATION;
            case ('/') : return ActionOnVariable.DIVISION;
            default : return null;
        }
    }
}

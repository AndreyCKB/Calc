package model.expressions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum ActionOnVariable {
    SUM("\\+", '+') {
        @Override
        public int execute(int... numbers) {
            int result = numbers[0];
            for (int i = 1; i < numbers.length; i++){
                result += numbers[i];
            }
            return result;
            }
    },
    SUBTRACTION("-" , '-') {
        @Override
        public int execute(int... numbers) {
            int result = numbers[0];
            for (int i = 1; i < numbers.length; i++){
                result -= numbers[i];
            }
            return result;
        }
    },

    DIVISION("/", '/') {
        @Override
        public int execute(int... numbers) {
            double result = numbers[0];
            for (int i = 1; i < numbers.length; i++){
                result /= numbers[i];
            }
            return new BigDecimal(result).setScale(5,RoundingMode.HALF_UP).intValue();
        }
    },
    MULTIPLICATION("\\*", '*') {
        @Override
        public int execute(int... numbers) {
            int result = numbers[0];
            for (int i = 1; i < numbers.length; i++){
                result *= numbers[i];
            }
            return result;
        }
    };

    private String act;
    private char sign;

    ActionOnVariable(String act , char sign) {
        this.act = act;
        this.sign = sign;
    }

    public String getAct() {
        return this.act;
    }
    public char getSign() {
        return this.sign;
    }

    public int execute(int... numbers){
        return this.execute(numbers);
    }
}


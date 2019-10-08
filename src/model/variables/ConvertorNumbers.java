package model.variables;

import java.util.HashMap;
import java.util.Map;

public class ConvertorNumbers {
    private static final ConvertorNumbers Instance = new ConvertorNumbers();
    private static final Map<Integer,String> RIM_AND_ARAB_NUMIRIC = new HashMap<>();

    static {
           Map<Integer,String> tempMap = new HashMap<>();
//            tempMap.put(1000, "M");
//           tempMap.put(900, "CM");
//            tempMap.put(500, "D");
//            tempMap.put(400, "CD");
           tempMap.put(100, "C");
           tempMap.put(90, "XC");
           tempMap.put(50, "L");
           tempMap.put(40, "XL");
           tempMap.put(10, "X");
           tempMap.put(9, "IX");
           tempMap.put(5, "V");
           tempMap.put(4, "IV");
           tempMap.put(1, "I");
           tempMap.put(0, "O");


           for (int i = 0; i < 101; i++) {
               String result = tempMap.get(i);

               if (result != null) {
                   RIM_AND_ARAB_NUMIRIC.put(i, result);
                   continue;
               }

               int temp;
               int number = i;
               StringBuilder sb = new StringBuilder();

               while (number > 0) {
                   temp = number;
                   for ( ; (result = tempMap.get(number)) == null ; --number );
                   sb.append(result);
                   number = temp - number;
               }

               RIM_AND_ARAB_NUMIRIC.put(i, sb.toString());
           }

        }

    private ConvertorNumbers() {
    }

    public static ConvertorNumbers getInstance() {
        return Instance;
    }

    public String convertArabNToRomN(int number) throws IllegalAccessException {
//            if (number < -100 || number > 100)
//                throw new IllegalAccessException("Введённое число [ " + number +" ] не попадает в диапазон от -100 до 100 включительно");
            if (number < 0)
                return ("-" + executeConvertArabNToRomN(-number));
            else
                return executeConvertArabNToRomN(number);
        }

        private  String executeConvertArabNToRomN(int number){
             return RIM_AND_ARAB_NUMIRIC.get(number);

        }

        public int convertRomNToArabN(String number) throws IllegalAccessException {
            if (number.isEmpty()) throw new IllegalAccessException("Переданная строка [ "+ number + " ] не является Римским числом.");
            boolean numberIsNegative = false;
            if ( number.toCharArray()[0] == '-' ) {
                number = new StringBuilder(number).delete(0,1).toString();
                numberIsNegative = true;
            }
            int result = executeConvertRomNToArabN(number , numberIsNegative);
            if (numberIsNegative) result = - result;
            return result;
        }

        private int executeConvertRomNToArabN(String number, boolean numberIsNegative) throws IllegalAccessException {
            Integer result = null;

            for (Integer romeN : RIM_AND_ARAB_NUMIRIC.keySet() ){
                if (RIM_AND_ARAB_NUMIRIC.get(romeN).equals(number)) result = romeN;
            }

            if ( result == null ) {
                if (numberIsNegative) number = "-" + number;
                throw new IllegalAccessException("Введённая строка [ "
                        + number
                        + " ] не попадпет в диапозон от -C до C  включительно или не являеется Римской цифрой");
            }
            return result;
        }

}


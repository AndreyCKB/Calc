package model.variables;

public interface Variables extends Comparable<Variables> {
  int getNumber();

  String variableToString();

  int compareTo(Variables o);

  Variables  valueOf(int number)  throws IllegalAccessException;

  Variables  valueOf(String number)  throws IllegalAccessException;
}

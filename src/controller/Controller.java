package controller;

import model.expressions.Expression;
import model.expressions.Models;
import model.variables.Variables;
import view.Views;

public class Controller {
    private static Controller ourInstance;
    private Views view;
    private Models model;

    public static Controller getInstance(Views view, Models model) {
        if (ourInstance != null) return ourInstance;
        ourInstance = new Controller(view, model);
        return ourInstance;
    }

    private Controller(Views view, Models model) {
        this.view = view;
        this.model = model;
    }

    public void start() throws Exception{
        String inputString ;
        greeting();
        while (!(inputString =view.getLine()).equals("exit")){
            Expression expression = model.getExpression(inputString);
            Variables variables = expression.getCalculatedResult();
            view.printInConsole(variables.variableToString());
            view.printInConsole("\nВведите следующую строку");
        }
        exit();
    }

    private void greeting(){
        view.printInConsole("Здравствуйте!" +
                "\nВведите арифметическое выражение содержащие только Арабские или только Римские числа" +
                "\nДля выхода введите \"exit\"");
    }

    private void exit() throws Exception{
        view.printInConsole("До новых встреч!");
        Thread.sleep(1000);
        view.close();
        System.exit(0);
    }


}

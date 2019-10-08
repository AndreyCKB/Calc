import controller.Controller;
import model.expressions.CreatExpressions;
import model.expressions.Models;
import view.ConsoleView;
import view.Views;

public class Main {

    public static void main(String...args) throws Exception {
                Views view = ConsoleView.getInstance();
                Models model = CreatExpressions.getInstance();
                Controller controller = Controller.getInstance(view, model);
                controller.start();
    }
}

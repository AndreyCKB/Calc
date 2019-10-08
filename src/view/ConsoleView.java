package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleView implements Views{
    private static ConsoleView ourInstance = new ConsoleView();
    private BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));



    private ConsoleView() {}

    public static ConsoleView getInstance() {
        return ourInstance;
    }

    public String getLine() throws IOException {
        return bufferedReader.readLine();
    }

    public void printInConsole(String st){
        System.out.println(st);
    }

    public void close() throws IOException {
        bufferedReader.close();
    }
}

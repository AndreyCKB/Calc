package view;


import java.io.IOException;

public interface Views {
    String getLine()  throws IOException;

    void printInConsole(String st);

    void close() throws IOException;

}

package com.kreitek.editor;

import com.kreitek.editor.commands.CommandFactory;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.strategies.PrintStrategy;
import com.kreitek.editor.utils.printers.DocumentPrinter;
import com.kreitek.editor.utils.printers.TextPrinter;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleEditor implements Editor {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    private final CommandFactory commandFactory = new CommandFactory();
    private ArrayList<String> documentLines = new ArrayList<String>();
    private TextPrinter textPrinter = TextPrinter.getInstance();
    private PrintStrategy printStrategy = DocumentPrinter.getInstance().getPrintStrategy();

    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            String commandLine = waitForNewCommand();
            try {
                Command command = commandFactory.getCommand(commandLine);
                command.execute(documentLines);
            } catch (BadCommandException e) {
                printErrorToConsole("Bad command");
            } catch (ExitException e) {
                exit = true;
            }
            showDocumentLines(documentLines);
            showHelp();
        }
    }

    private void showDocumentLines(ArrayList<String> textLines) {
        if (textLines.size() > 0){
            textPrinter.setTextColor(TEXT_YELLOW);
            textPrinter.printLnToConsole("START DOCUMENT ==>");
            printStrategy.printDocument(textLines);
            textPrinter.printLnToConsole("<== END DOCUMENT");
            textPrinter.setTextColor(TEXT_RESET);
        }
    }

    private String waitForNewCommand() {
        textPrinter.printToConsole("Enter a command : ");
        Scanner scanner = new Scanner(System. in);
        return scanner.nextLine();
    }

    private void showHelp() {
        textPrinter.printLnToConsole("To add new line -> a \"your text\"");
        textPrinter.printLnToConsole("To update line  -> u [line number] \"your text\"");
        textPrinter.printLnToConsole("To delete line  -> d [line number]");
    }

    private void printErrorToConsole(String message) {
        textPrinter.setTextColor(TEXT_RED);
        textPrinter.printToConsole(message);
        textPrinter.setTextColor(TEXT_RESET);
    }

}

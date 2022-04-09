package com.kreitek.editor.strategies;

import com.kreitek.editor.utils.printers.TextPrinter;

import java.util.List;

public class JSONStrategy implements PrintStrategy {
    // Propiedades.
    private TextPrinter textPrinter = TextPrinter.getInstance();

    @Override
    public void printDocument(List<String> document) {
        // Cabecera JSON
        textPrinter.printLnToConsole("{");
        textPrinter.printLnToConsole("\t\"doc\":[");

        // Cuerpo JSON
        for (int index = 0; index < document.size(); index++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\"line\":\"" + index + "\",");
            stringBuilder.append("\"text\":\"" + document.get(index) + "\"}");
            textPrinter.printLnToConsole("\t\t" + stringBuilder.toString());
        }

        // Pie JSON
        textPrinter.printLnToConsole("\t]");
        textPrinter.printLnToConsole("}");
    }
}

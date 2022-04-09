package com.kreitek.editor.strategies;

import com.kreitek.editor.utils.printers.TextPrinter;

import java.util.List;

public class TextStrategy implements PrintStrategy{
    // Propiedades.
    private TextPrinter textPrinter = TextPrinter.getInstance();

    @Override
    public void printDocument(List<String> document) {
        for (int index = 0; index < document.size(); index++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append(index);
            stringBuilder.append("] ");
            stringBuilder.append(document.get(index));
            textPrinter.printLnToConsole(stringBuilder.toString());
        }
    }
}

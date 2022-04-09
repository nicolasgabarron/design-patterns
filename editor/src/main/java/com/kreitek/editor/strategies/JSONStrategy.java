package com.kreitek.editor.strategies;

import com.kreitek.editor.utils.printers.TextPrinter;

import java.util.List;

public class JSONStrategy implements PrintStrategy{
    // Propiedades.
    private TextPrinter textPrinter = TextPrinter.getInstance();

    @Override
    public void printDocument(List<String> document) {

    }
}

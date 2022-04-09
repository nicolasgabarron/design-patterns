package com.kreitek.editor.utils.printers;

import org.w3c.dom.Text;

import java.util.List;

public class TextPrinter{
    // Propiedades.
    private static TextPrinter textPrinter;

    /**
     * PATRÓN SINGLETON.
     * Método que nos devuelve una instancia única de TextPrinter.
     *
     * @return Instancia de TextPrinter.
     */
    public static TextPrinter getInstance(){
        if(textPrinter == null){
            textPrinter = new TextPrinter();
        }

        return textPrinter;
    }

    public void setTextColor(String color) {
        System.out.println(color);
    }

    public void printLnToConsole(String message) {
        System.out.println(message);
    }

    public void printToConsole(String message) {
        System.out.print(message);
    }

}

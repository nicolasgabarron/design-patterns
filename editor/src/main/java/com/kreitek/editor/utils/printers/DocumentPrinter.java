package com.kreitek.editor.utils.printers;

import com.kreitek.editor.strategies.PrintStrategy;

import java.util.List;

public class DocumentPrinter {
    // Propiedades.
    private PrintStrategy printStrategy;
    private List<String> document;
    private static DocumentPrinter documentPrinter;

    /**
     * PATRÓN SINGLETON.
     * Método que nos ayuda a recuperar la instancia de clase única que se encargará de
     * imprimir el documento.
     *
     * Definirá la estrategia en el método MAIN, en función al parámetro 0 pasado en la ejecución.
     *
     * Utilizo este patrón para que a posterior en el ConsoleEditor pueda utilizar la estrategia definida para imprimir
     * el documento.
     *
     * @return Instancia de DocumentPrinter.
     */
    public static DocumentPrinter getInstance(){
        if(documentPrinter==null){
            documentPrinter = new DocumentPrinter();
        }

        return documentPrinter;
    }


    // Getters y Setters.
    public PrintStrategy getPrintStrategy() {
        return printStrategy;
    }

    public void setPrintStrategy(PrintStrategy printStrategy) {
        this.printStrategy = printStrategy;
    }

    public List<String> getDocument() {
        return document;
    }

    public void setDocument(List<String> document) {
        this.document = document;
    }
}

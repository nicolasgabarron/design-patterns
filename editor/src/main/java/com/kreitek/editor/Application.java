package com.kreitek.editor;

import com.kreitek.editor.strategies.JSONStrategy;
import com.kreitek.editor.strategies.TextStrategy;
import com.kreitek.editor.utils.printers.DocumentPrinter;

public class Application {

    public static void main(String[] args) {
        EditorFactory editorFactory = new EditorFactory();
        DocumentPrinter documentPrinter = DocumentPrinter.getInstance();

        // Defino la estrategia de ejecución del programa.
        try{
            if (args[0].equalsIgnoreCase("JSON")) {
                documentPrinter.setPrintStrategy(new JSONStrategy());
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("No se ha especificado método de arranque... Arrancando en modo TEXTO.");
            documentPrinter.setPrintStrategy(new TextStrategy());
        }


        Editor editor = editorFactory.getEditor();
        editor.run();
    }

}

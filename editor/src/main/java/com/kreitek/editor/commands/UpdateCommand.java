package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.Editor;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.history.EditorMemento;
import com.kreitek.editor.publishers.EventManager;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    // Propiedades.
    private final String text;
    private final int lineNumber;
    private EventManager eventManager = EventManager.getInstance();

    public UpdateCommand(String text, int lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }

    /**
     * Método execute que modifica lineas de un documento.
     *
     * Previa eliminación hace un "save" manejado mediante el patrón Observer.
     *
     * @param documentLines Simulación de documento.
     */
    @Override
    public void execute(ArrayList<String> documentLines) {
        eventManager.notify("saveDocument", documentLines);

        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
    }
}

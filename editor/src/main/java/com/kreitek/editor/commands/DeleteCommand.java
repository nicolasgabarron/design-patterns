package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.history.EditorMemento;
import com.kreitek.editor.publishers.EventManager;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    // Propiedades.
    private final int lineNumber;
    private EventManager eventManager = EventManager.getInstance();

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * Método execute que elimina lineas de un documento.
     *
     * Previa eliminación hace un "save" manejado mediante el patrón Observer.
     *
     * @param documentLines Simulación de documento.
     */
    @Override
    public void execute(ArrayList<String> documentLines) {
        eventManager.notify("saveDocument", documentLines);
        documentLines.remove(lineNumber);
    }
}

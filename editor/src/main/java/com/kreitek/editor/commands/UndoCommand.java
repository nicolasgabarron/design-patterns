package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.publishers.EventManager;

import java.util.ArrayList;
import java.util.List;

public class UndoCommand implements Command {
    // Propiedades.
    EventManager eventManager = EventManager.getInstance();

    /**
     * Método execute que notifica al evento "undo" que debe deshacer cambios
     * con la lista "documentLines".
     *
     * @param documentLines Simulación de documento..
     */
    @Override
    public void execute(ArrayList<String> documentLines) {
        eventManager.notify("undoDocument", documentLines);
    }
}

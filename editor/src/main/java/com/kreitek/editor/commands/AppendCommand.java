package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.history.EditorMemento;
import com.kreitek.editor.publishers.EventManager;

import java.util.ArrayList;

public class AppendCommand implements Command {
    // Propiedades
    private final String text;
    private EventManager eventManager = EventManager.getInstance();

    public AppendCommand(String text) {
        this.text = text;
    }

    /**
     * Método execute que añade lineas a un documento.
     *
     * Previa eliminación hace un "save" manejado mediante el patrón Observer.
     *
     * @param documentLines Simulación de documento.
     */
    @Override
    public void execute(ArrayList<String> documentLines) {
        eventManager.notify("saveDocument", documentLines);
        documentLines.add(text);
    }
}

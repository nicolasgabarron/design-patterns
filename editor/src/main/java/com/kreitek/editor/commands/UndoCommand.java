package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.history.EditorCareTaker;

import java.util.ArrayList;
import java.util.List;

public class UndoCommand implements Command {
    /**
     *  Método que utiliza la referencia al documento original para reemplazarlo
     *  con el documento (ArrayList) recuperado del Memento.
     * @param careTaker CareTaker del editor a modo global (Referencia).
     * @param documentLines Documento original del editor a modo global (Referencia).
     */
    @Override
    public void execute(EditorCareTaker careTaker, ArrayList<String> documentLines) {
        documentLines = careTaker.pop().getState();
    }
}

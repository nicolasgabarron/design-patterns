package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.history.EditorMemento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    // Propiedades.
    private final int lineNumber;
    private EditorCareTaker careTaker = EditorCareTaker.getInstance();

    public DeleteCommand(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        careTaker.push(new EditorMemento(documentLines)); // Creo el memento a la vez que lo guardo.
        documentLines.remove(lineNumber);
    }
}

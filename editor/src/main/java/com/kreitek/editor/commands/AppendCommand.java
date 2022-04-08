package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.history.EditorMemento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    // Propiedades.
    private final String text;
    private EditorCareTaker careTaker = EditorCareTaker.getInstance();

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        careTaker.push(new EditorMemento(documentLines)); // Creo el memento a la vez que lo guardo.
        documentLines.add(text);
    }
}

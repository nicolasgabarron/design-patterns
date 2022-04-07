package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.history.EditorMemento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;

    public AppendCommand(String text) {
        this.text = text;
    }

    @Override
    public void execute(EditorCareTaker careTaker, ArrayList<String> documentLines) {
        careTaker.push(new EditorMemento(documentLines)); // Creo el memento a la vez que lo guardo.
        documentLines.add(text);
    }
}

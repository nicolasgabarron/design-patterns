package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.history.EditorMemento;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;

    public UpdateCommand(String text, int lineNumber) {
        this.text = text;
        this.lineNumber = lineNumber;
    }

    @Override
    public void execute(EditorCareTaker careTaker, ArrayList<String> documentLines) {
        careTaker.push(new EditorMemento(documentLines)); // Creo el memento a la vez que lo guardo.

        if (documentLines.size() > lineNumber)
            documentLines.set(lineNumber, text);
        else
            documentLines.add(text);
    }
}

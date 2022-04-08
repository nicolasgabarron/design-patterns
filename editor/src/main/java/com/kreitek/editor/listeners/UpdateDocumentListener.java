package com.kreitek.editor.listeners;

import com.kreitek.editor.history.EditorCareTaker;
import com.kreitek.editor.history.EditorMemento;

import java.util.ArrayList;

public class UpdateDocumentListener implements EventListener{
    // Propiedades
    private EditorCareTaker careTaker;

    public UpdateDocumentListener(EditorCareTaker careTaker) {
        this.careTaker = careTaker;
    }

    @Override
    public void update(ArrayList<String> document) {
        careTaker.push(new EditorMemento(document));
    }
}

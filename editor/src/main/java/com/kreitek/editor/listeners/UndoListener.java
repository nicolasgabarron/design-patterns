package com.kreitek.editor.listeners;

import com.kreitek.editor.history.EditorCareTaker;

import java.util.ArrayList;

public class UndoListener implements EventListener{
    // Propiedades.
    EditorCareTaker careTaker;

    public UndoListener(EditorCareTaker careTaker) {
        this.careTaker = careTaker;
    }

    @Override
    public void update(ArrayList<String> document) {
        //document = careTaker.pop().getState();
        document.removeAll(document);
        document.addAll(careTaker.pop().getState());
    }
}

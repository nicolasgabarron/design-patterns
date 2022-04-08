package com.kreitek.editor.listeners;

import com.kreitek.editor.history.EditorCareTaker;

import java.util.ArrayList;

public class UndoListener implements EventListener{
    // Propiedades.
    EditorCareTaker careTaker = EditorCareTaker.getInstance();


    /**
     * Método execute que recupera líneas de un documento.
     *
     * Previa eliminación hace un "save" manejado mediante el patrón Observer.
     */
    @Override
    public void update(ArrayList<String> document) {
        document.clear();
        try{
            ArrayList<String> savedDocument = careTaker.pop().getState();
            document.addAll(savedDocument);
        } catch (NullPointerException e){
            System.err.println("ERROR. No hay más puntos de recuperación.");
        }

    }
}

package com.kreitek.editor.history;

import java.util.ArrayList;

public class EditorMemento {
    // Propiedades.
    private ArrayList<String> state; // Almacenará una lista de líneas en un momento dado.

    /**
     * Constructor que crea un nuevo memento en función a una lista "documento" pasada por parámetro.
     *
     * Dentro de éste creo un nuevo ArrayList con el contenido del ArrayList pasado por parámetro ya que
     * si los igualara, todos los mementos harían referencia a la misma lista y no podríamos tener
     * un historial de cambios.
     *
     * @param documentLines Documento a "salvar" o del que crear un "snapshot"(memento).
     */
    public EditorMemento(ArrayList<String> documentLines) {
        this.state = new ArrayList<>(documentLines);
    }

    /**
     * Método que nos devuelve el estado de este memento.
     *
     * Será útil cuando utilicemos el método .pop() de la clase "CareTaker".
     *
     * @return Estado del documento en el memento.
     */
    public ArrayList<String> getState(){
        return this.state;
    }
}

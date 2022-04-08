package com.kreitek.editor.history;

import com.kreitek.editor.Editor;

import java.util.ArrayList;
import java.util.List;

public class EditorCareTaker {
    // Propiedades.
    private List<EditorMemento> mementoList = new ArrayList<>();
    private static EditorCareTaker careTaker;

    /**
     * PATRÓN SINGLETON.
     * Método que nos devuelve una instancia de EditorCareTaker.
     *
     * @return Instancia de EditorCareTaker.
     */
    private static EditorCareTaker getInstance(){
        if(careTaker==null){
            careTaker = new EditorCareTaker();
        }

        return careTaker;
    }

    /**
     * Constructor por defecto privado para que la única manera de
     * instanciar la clase sea mediante "getInstance()".
     */
    private EditorCareTaker(){}

    /**
     * Método que introduce en la lista de mementos (pila de "snapshots") un nuevo
     * memento.
     *
     * @param memento Memento a introducir en la lista.
     */
    public void push(EditorMemento memento){
        mementoList.add(memento);
    }

    /**
     * Método que recupera y devuelve el último elemento de la lista de mementos
     * (pila de "snapshots") y posteriormente lo elimina.
     *
     * @return Último memento disponible. En caso de no haber mementos, devuelve NULL.
     */
    public EditorMemento pop(){
        if(mementoList.size()>0){
            final int LAST_INDEX = mementoList.size()-1; // Índice del último elemento de la lista.

            EditorMemento mementoPop = mementoList.get(LAST_INDEX);
            mementoList.remove(LAST_INDEX);

            return mementoPop;
        }

        return null;
    }
}

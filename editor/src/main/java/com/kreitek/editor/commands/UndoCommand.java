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
    public void execute(ArrayList<String> documentLines) {
        // documentLines = careTaker.pop().getState(); ¿Debería funcionar? Estoy cambiando referencias...

        try{
            //documentLines.removeAll(documentLines);
            // documentLines.addAll(careTaker.pop().getState());
        }catch (NullPointerException e){
            System.out.println("ERROR. No hay ningún cambio que se pueda recuperar.");
        }

    }
}

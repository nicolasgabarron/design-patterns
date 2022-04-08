package com.kreitek.editor.publishers;


import com.kreitek.editor.listeners.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    /**
     * Constructor por defecto mediante el cual se crean eventos con un nombre
     * y asociados a ese nombre llevan una lista de "subscriptores".
     *
     * @param operations Lista de nombres de evento.
     */
    public EventManager(String... operations){
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    /**
     * Método por el que obtengo la lista de un determinado evento y añado
     * un subscriptor.
     *
     * @param eventName Nombre del evento.
     * @param listener Listener que quiero subscribir al evento.
     */
    public void subscribe(String eventName, EventListener listener){
        List<EventListener> subscribers = this.listeners.get(eventName);
        subscribers.add(listener);
    }

    /**
     * Método por el que obtengo la lista de un determinado evento y elimino
     * un subscriptor.
     *
     * @param eventName Nombre del evento.
     * @param listener Listener que quiero de-subscribir al evento.
     */
    public void unsubscribe(String eventName, EventListener listener){
        List<com.kreitek.editor.listeners.EventListener> subscribers = this.listeners.get(eventName);
        subscribers.remove(listener);
    }

    public void notify(String eventName, ArrayList<String> document){
        List<EventListener> subscribers = this.listeners.get(eventName);
        for (EventListener listener : subscribers) {
            listener.update(document);
        }
    }
}

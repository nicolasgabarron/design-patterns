package com.kreitek.pets.loggers;

public class Logger {
    // Propiedades.
    private static Logger logger; // Instancia de Logger que será devuelta por 'getInstance()'.
    private static int contador = 0; // Contador global que sumará 1 cada vez que se llame al método 'debug()'.

    private Logger(){
    }

    /**
     * Método que crea una instancia de Logger en caso de no existir.
     * En caso de existir, devuelve la instancia en memoria.
     * Esta es la única manera de crear objetos Logger, ya que su constructor es privado.
     *
     * PATRÓN SINGLETON.
     *
     * @return instancia de Logger.
     */
    public static Logger getInstance(){
        if(logger==null){
            logger = new Logger();
        }

        return logger;
    }


    /**
     * Método que imprime por consola el mensaje de debug a modo Log.
     * Formato: [debug][numeroDebug] mensaje.
     *
     * Anotación: Incremento en 1 el contador antes de mostrar el mensaje por consola
     * debido a que quiero que el índice inicial del primer mensaje de Log sea 1.
     *
     * @param msg Mensaje a imprimir.
     */
    public void debug(String msg){
        contador++;
        System.out.println("[debug][" + contador + "] - " + msg);
    }

}

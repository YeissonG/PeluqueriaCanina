package peluqueriacanina.persistencia.exceptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se encarga de manejar errores de "Huérfanos Legales". Ocurre
 * cuando intentas borrar un registro (como un Dueño) que todavía tiene objetos
 * asociados (como una Mascota) que no pueden quedarse solos.
 */
public class IllegalOrphanException extends Exception {

    // Lista para almacenar los mensajes de error detallados
    private final List<String> messages;

    /**
     * Constructor que recibe una lista de mensajes de error.
     *
     * @param messages Lista de razones por las cuales no se pudo realizar la
     * operación.
     */
    public IllegalOrphanException(List<String> messages) {
        // Llama al constructor de la clase padre (Exception) enviando el primer mensaje de la lista
        super((messages != null && !messages.isEmpty() ? messages.get(0) : null));

        // Si la lista recibida es nula, inicializa una lista vacía para evitar errores de puntero nulo
        if (messages == null) {
            this.messages = new ArrayList<>();
        } else {
            // Si hay mensajes, los asigna a la variable interna de la clase
            this.messages = messages;
        }
    }

    /**
     * Permite obtener la lista completa de errores que causaron la excepción.
     *
     * @return Una lista de cadenas de texto con los detalles.
     */
    public List<String> getMessages() {
        return messages;
    }
}

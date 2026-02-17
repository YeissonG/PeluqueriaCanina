package peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase Entidad Dueño. Representa la tabla 'Duenio' en la base de datos.
 * Almacena la información de contacto del propietario de la mascota.
 */
@Entity
public class Duenio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_duenio;
    private String nombre;
    private String cel_duenio;

    /**
     * Constructor vacío requerido por JPA para la instanciación de entidades.
     */
    public Duenio() {
    }

    /**
     * Constructor con parámetros para crear un objeto Dueño con datos
     * iniciales.
     *
     * @param id_duenio Identificador único en la base de datos.
     * @param nombre Nombre completo del dueño.
     * @param celDuenio Número de teléfono de contacto.
     */
    public Duenio(int id_duenio, String nombre, String celDuenio) {
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.cel_duenio = celDuenio;
    }

    // --- MÉTODOS ACCESORES (Getters y Setters) ---
    public int getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el celular del dueño.
     *
     * @return String con el número telefónico.
     */
    public String getCelDuenio() {
        return cel_duenio;
    }

    /**
     * Asigna el celular del dueño.
     *
     * @param celDuenio El número telefónico a establecer.
     */
    public void setCelDuenio(String celDuenio) {
        this.cel_duenio = celDuenio;
    }
}

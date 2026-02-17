package peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Clase Entidad Mascota. Representa la tabla 'Mascota' en la base de datos.
 * Incluye la relación uno a uno con el dueño.
 */
@Entity
public class Mascota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int num_cliente;
    private String nombre;
    private String raza;
    private String color;
    private String alergico;
    private String atencion_especial;
    private String observaciones;

    @OneToOne
    @JoinColumn(name = "id_duenio")
    private Duenio unDuenio;

    /**
     * Constructor vacío obligatorio para el funcionamiento de JPA.
     */
    public Mascota() {
    }

    /**
     * Constructor con parámetros para inicializar una mascota con todos sus
     * datos.
     *
     * @param num_cliente ID único del cliente.
     * @param nombre Nombre de la mascota.
     * @param raza Raza de la mascota.
     * @param color Color del pelaje.
     * @param alergico Si es alérgico o no.
     * @param atencion_especial Si requiere atención especial.
     * @param observaciones Detalles o notas clínicas.
     * @param unDuenio Objeto Dueño asociado a la mascota.
     */
    public Mascota(int num_cliente, String nombre, String raza, String color, String alergico, String atencion_especial, String observaciones, Duenio unDuenio) {
        this.num_cliente = num_cliente;
        this.nombre = nombre;
        this.raza = raza;
        this.color = color;
        this.alergico = alergico;
        this.atencion_especial = atencion_especial;
        this.observaciones = observaciones;
        this.unDuenio = unDuenio;
    }

    // --- MÉTODOS ACCESORES (Getters y Setters) ---
    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getAtencion_especial() {
        return atencion_especial;
    }

    public void setAtencion_especial(String atencion_especial) {
        this.atencion_especial = atencion_especial;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Duenio getUnDuenio() {
        return unDuenio;
    }

    public void setUnDuenio(Duenio unDuenio) {
        this.unDuenio = unDuenio;
    }
}

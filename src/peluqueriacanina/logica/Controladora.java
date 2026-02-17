package peluqueriacanina.logica;

import java.util.List;
import peluqueriacanina.persistencia.ControladoraPersistencia;

/**
 * Clase Controladora de la Lógica. Actúa como intermediaria entre la Interfaz
 * Gráfica y la Capa de Persistencia. Aquí se coordinan las acciones de negocio
 * antes de enviarlas a la base de datos.
 */
public class Controladora {

    // Instancia de la persistencia para delegar el almacenamiento de datos
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    /**
     * Método para registrar una nueva mascota y su respectivo dueño.Crea los
     * objetos necesarios y establece la relación entre ellos.
     *
     * @param nombreMasco Nombre del canino.
     * @param raza Raza de la mascota.
     * @param color Color del pelaje.
     * @param alergico Indica si posee alergias ("Si" / "No").
     * @param atenEsp Indica si requiere cuidados especiales.
     * @param observaciones Notas adicionales sobre la mascota.
     * @param nombreDuenio Nombre completo del propietario.
     * @param celDuenio Teléfono de contacto del dueño.
     */
    public void guardar(String nombreMasco, String raza, String color,
            String alergico, String atenEsp, String observaciones,
            String nombreDuenio, String celDuenio) {

        // 1. Creación y asignación de datos del Dueño
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);

        // 2. Creación y asignación de datos de la Mascota
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp); // Refactorizado: Se asigna correctamente el campo
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio); // Vinculación mediante Relación 1-a-1 u Objetos

        // 3. Persistencia de datos (Llamado a la capa inferior)
        controlPersis.guardar(duenio, masco);
    }

    /**
     * Recupera la lista completa de mascotas desde la base de datos.
     *
     * @return List de objetos Mascota.
     */
    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    /**
     * Elimina una mascota y su registro asociado por ID.
     *
     * @param num_cliente ID único de la mascota a borrar.
     */
    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    /**
     * Busca una mascota específica en la base de datos.
     *
     * @param num_cliente ID de búsqueda.
     * @return El objeto Mascota encontrado.
     */
    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    /**
     * Modifica los datos de una mascota y su dueño ya existentes.Se encarga de
     * actualizar los dos objetos vinculados.
     *
     * @param masco El objeto mascota original a modificar.
     * @param nombreMasco Nuevo nombre.
     * @param raza Nueva raza.
     * @param color Nuevo color.
     * @param alergico Actualización de alergias.
     * @param atenEsp Actualización de atención especial.
     * @param observaciones Nuevas notas clínicas.
     * @param nombreDuenio Nuevo nombre del dueño.
     * @param celDuenio Nuevo celular del dueño.
     */
    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color,
            String alergico, String atenEsp, String observaciones, String nombreDuenio, String celDuenio) {

        // 1. Actualización de datos de la Mascota
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atenEsp);
        masco.setAlergico(alergico);

        // Ejecución de cambios en la tabla mascota
        controlPersis.modificarMascota(masco);

        // 2. Recuperación y actualización del Dueño vinculado
        Duenio dueno = masco.getUnDuenio();
        dueno.setNombre(nombreDuenio);
        dueno.setCelDuenio(celDuenio);

        // Ejecución de cambios en la tabla duenio
        controlPersis.modificarDuenio(dueno);
    }
}

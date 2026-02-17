package peluqueriacanina.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import peluqueriacanina.logica.Duenio;
import peluqueriacanina.logica.Mascota;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

/**
 * Clase Controladora de Persistencia. Se encarga de centralizar todas las
 * operaciones hacia los JPA Controllers. Gestiona el ciclo de vida del
 * EntityManagerFactory y la comunicación con MySQL.
 */
public class ControladoraPersistencia {

    // EntityManagerFactory: Punto de acceso a la unidad de persistencia configurada en persistence.xml
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PeluqueriaCaninaPU");

    // Instancias de los controladores JPA específicos para cada entidad
    private final DuenioJpaController duenioJpa = new DuenioJpaController(emf);
    private final MascotaJpaController mascoJpa = new MascotaJpaController(emf);

    /**
     * Persiste los objetos Dueño y Mascota en sus respectivas tablas.
     *
     * @param duenio Objeto de tipo Duenio con datos de contacto.
     * @param masco Objeto de tipo Mascota vinculado al dueño.
     */
    public void guardar(Duenio duenio, Mascota masco) {
        duenioJpa.create(duenio); // Inserta el dueño primero por integridad referencial
        mascoJpa.create(masco);   // Inserta la mascota vinculada
    }

    /**
     * Recupera todos los registros de la tabla mascota.
     *
     * @return Lista de todas las mascotas almacenadas.
     */
    public List<Mascota> traerMascotas() {
        return mascoJpa.findMascotaEntities();
    }

    /**
     * Elimina una mascota de la base de datos de forma física.
     *
     * @param num_cliente ID del registro a eliminar.
     */
    public void borrarMascota(int num_cliente) {
        try {
            mascoJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "No se encontró el cliente a borrar", ex);
        }
    }

    /**
     * Busca una mascota por su llave primaria (ID).
     *
     * @param num_cliente Identificador de la mascota.
     * @return Objeto Mascota si existe, null en caso contrario.
     */
    public Mascota traerMascota(int num_cliente) {
        return mascoJpa.findMascota(num_cliente);
    }

    /**
     * Actualiza los datos de una mascota existente mediante la operación merge.
     *
     * @param masco Objeto mascota con los datos ya actualizados en la lógica.
     */
    public void modificarMascota(Mascota masco) {
        try {
            mascoJpa.edit(masco);
        } catch (Exception ex) {
            // Sustituimos System.out por Logger para un manejo profesional de errores
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al actualizar mascota", ex);
        }
    }

    /**
     * Actualiza los datos del dueño en la base de datos.
     *
     * @param dueno Objeto dueño con los datos modificados.
     */
    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, "Error al actualizar dueño", ex);
        }
    }
}

package peluqueriacanina.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import peluqueriacanina.logica.Mascota;
import peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

/**
 * Controlador JPA para la entidad Mascota. Maneja el ciclo de vida de los datos
 * de las mascotas en la base de datos utilizando transacciones de
 * EntityManager.
 */
public class MascotaJpaController implements Serializable {

    /**
     * Constructor que recibe la factoría de gestión de entidades.
     *
     * @param emf Fábrica de EntityManager para la conexión.
     */
    public MascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    /**
     * Crea un nuevo gestor de entidades para realizar operaciones.
     *
     * @return Instancia de EntityManager.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Inserta una nueva Mascota en la base de datos.
     *
     * @param mascota Objeto Mascota a persistir.
     */
    public void create(Mascota mascota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin(); // Inicia la transacción
            em.persist(mascota);         // Guarda el objeto
            em.getTransaction().commit(); // Confirma los cambios
        } finally {
            if (em != null) {
                em.close(); // Siempre cerrar el recurso al finalizar
            }
        }
    }

    /**
     * Actualiza un registro de Mascota existente (Operación MERGE).
     *
     * @param mascota Objeto con los datos actualizados.
     * @throws NonexistentEntityException Si el ID ya no existe en la BD.
     * @throws Exception Errores generales de persistencia.
     */
    public void edit(Mascota mascota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mascota = em.merge(mascota); // Fusiona los cambios con el registro actual
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = mascota.getNum_cliente();
                if (findMascota(id) == null) {
                    throw new NonexistentEntityException("La mascota con id " + id + " ya no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Elimina físicamente una mascota por su ID (Operación DELETE).
     *
     * @param id Identificador único de la mascota.
     * @throws NonexistentEntityException Si no se encuentra el registro.
     */
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mascota mascota;
            try {
                // Obtiene una referencia al objeto sin cargar todos sus datos
                mascota = em.getReference(Mascota.class, id);
                mascota.getNum_cliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("La mascota con id " + id + " ya no existe.", enfe);
            }
            em.remove(mascota); // Elimina el registro
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Busca y retorna todas las mascotas registradas.
     *
     * @return Lista de objetos Mascota.
     */
    public List<Mascota> findMascotaEntities() {
        return findMascotaEntities(true, -1, -1);
    }

    /**
     * Método interno para realizar consultas de selección (SELECT *).
     */
    private List<Mascota> findMascotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mascota.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Busca una mascota por su llave primaria.
     *
     * @param id ID de búsqueda.
     * @return El objeto Mascota o null si no existe.
     */
    public Mascota findMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mascota.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Cuenta el total de registros en la tabla Mascota.
     *
     * @return Cantidad entera de registros.
     */
    public int getMascotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mascota> rt = cq.from(Mascota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

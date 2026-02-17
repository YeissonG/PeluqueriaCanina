package peluqueriacanina.persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import peluqueriacanina.logica.Duenio;
import peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

/**
 * Controlador JPA para la entidad Duenio. Gestiona todas las operaciones de
 * lectura y escritura en la tabla 'Duenio' mediante el uso de transacciones
 * seguras.
 */
public class DuenioJpaController implements Serializable {

    /**
     * Constructor que recibe la factoría de conexión.
     *
     * @param emf Fábrica para generar el gestor de entidades.
     */
    public DuenioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    /**
     * Obtiene una instancia del EntityManager para interactuar con la BD.
     *
     * @return EntityManager activo.
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Registra un nuevo dueño en la base de datos.
     *
     * @param duenio Objeto Duenio con la información de contacto.
     */
    public void create(Duenio duenio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Actualiza los datos de un dueño ya existente.
     *
     * @param duenio Objeto Dueño con la información modificada.
     * @throws NonexistentEntityException Si el ID del dueño no se encuentra.
     * @throws Exception Errores generales durante la actualización.
     */
    public void edit(Duenio duenio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            duenio = em.merge(duenio);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = duenio.getId_duenio();
                if (findDuenio(id) == null) {
                    throw new NonexistentEntityException("El dueño con id " + id + " ya no existe.");
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
     * Elimina un registro de dueño de la base de datos.
     *
     * @param id Identificador único del dueño a borrar.
     * @throws NonexistentEntityException Si el registro no existe.
     */
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Duenio duenio;
            try {
                duenio = em.getReference(Duenio.class, id);
                duenio.getId_duenio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El dueño con id " + id + " ya no existe.", enfe);
            }
            em.remove(duenio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Recupera todos los dueños almacenados en el sistema.
     *
     * @return Lista de objetos Duenio.
     */
    public List<Duenio> findDuenioEntities() {
        return findDuenioEntities(true, -1, -1);
    }

    /**
     * Método auxiliar para consultas paginadas o completas.
     */
    private List<Duenio> findDuenioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Duenio.class));
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
     * Busca un dueño específico por su ID.
     *
     * @param id Llave primaria del dueño.
     * @return Objeto Duenio encontrado o null.
     */
    public Duenio findDuenio(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Duenio.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * Devuelve el número total de dueños registrados.
     *
     * @return Conteo total (entero).
     */
    public int getDuenioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Duenio> rt = cq.from(Duenio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

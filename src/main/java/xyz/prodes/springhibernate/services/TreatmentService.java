package xyz.prodes.springhibernate.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.REQUIRES_NEW;
import org.springframework.stereotype.Service;
import xyz.prodes.springhibernate.entities.Treatment;

/**
 *
 * @author АРТЁМ
 */
@Service
public class TreatmentService {
    
    @PersistenceContext(unitName = "unit", type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    
    @Transactional(REQUIRES_NEW)
    public Treatment findById(Integer id) {
        Query query = entityManager.createNamedQuery(Treatment.FIND_BY_ID);
        query.setParameter("id", id);
        Treatment treatment = (Treatment) query.getSingleResult();
        return treatment;
    }
}

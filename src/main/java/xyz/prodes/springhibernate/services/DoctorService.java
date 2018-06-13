package xyz.prodes.springhibernate.services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import xyz.prodes.springhibernate.entities.user.Doctor;

/**
 *
 * @author АРТЁМ
 */
@Service
public class DoctorService {
    
    @PersistenceContext(unitName = "unit", type=PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    
    public List<Doctor> findAll(){
        Query query = entityManager.createNamedQuery(Doctor.FIND_ALL);
        return query.getResultList();
    }
    
    public Doctor findById(Integer id) {
        Query query = entityManager.createNamedQuery(Doctor.FIND_BY_ID);
        query.setParameter("id", id);
        Doctor doctor = (Doctor) query.getSingleResult();
        return doctor;
    }
}

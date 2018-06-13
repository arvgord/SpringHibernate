package xyz.prodes.springhibernate.entities.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author АРТЁМ
 */
@NamedQueries({
    @NamedQuery(
        name = Doctor.FIND_BY_ID,
        query = "from Doctor where id=:id"
    )
    ,
    @NamedQuery(
        name = Doctor.FIND_ALL,
        query = "from Doctor"
    )
})
@Entity
@Table(name = "doctors")
public class Doctor extends AbstractUser implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public final static String FIND_BY_ID = "findDoctorById";
    public final static String FIND_ALL = "findAllDoctors";

    public Doctor() {
    }
}

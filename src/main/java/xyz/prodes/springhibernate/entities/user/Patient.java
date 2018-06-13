package xyz.prodes.springhibernate.entities.user;

import java.io.Serializable;

/**
 *
 * @author АРТЁМ
 */
public class Patient extends AbstractUser implements Serializable {

    private static final long serialVersionUID = 2L;
    private Doctor doctor;

    public Patient() {
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

package xyz.prodes.springhibernate.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author АРТЁМ
 */
@NamedQueries({
    @NamedQuery(
        name = Treatment.FIND_BY_ID,
        query = "from Treatment where id=:id"
    )
})
@Entity
@Table(name = "treatments")
public class Treatment implements Serializable {
    
    private static final long serialVersionUID = 3L;
    public final static String FIND_BY_ID = "findTreatmentById";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "complaint")
    private String complaint;
    @Column(name = "diagnosis")
    private String diagnosis;
    @Column(name = "start_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date endDate;
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Column(name = "patient_id")
    private Integer patientId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "treatment_id")
    private List<Prescription> prescriptions = new ArrayList<>();

    public Treatment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }
}

package xyz.prodes.springhibernate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.prodes.springhibernate.entities.user.Doctor;
import xyz.prodes.springhibernate.services.DoctorService;
import xyz.prodes.springhibernate.entities.Treatment;
import xyz.prodes.springhibernate.services.TreatmentService;

/**
 *
 * @author ARTYOM
 */
@RestController
public class UserController{
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private TreatmentService treatmentService;
    
    @RequestMapping(value = "/doctor/{id}", method = RequestMethod.GET)
    public Doctor getDoctor(@PathVariable Integer id) {
        return doctorService.findById(id);
    }
    
    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public List<Doctor> getDoctors() {
        return doctorService.findAll();
    }
    
    @RequestMapping(value = "/treatment/{id}", method = RequestMethod.GET)
    public Treatment getTreatment(@PathVariable Integer id) {
        return treatmentService.findById(id);
    }
}

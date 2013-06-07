/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
/**
 *
 * @author Sebastian
 */
@Entity
public class MedicalRecord {
    @Id
    private Integer idHistoria;
    
    private List<Appointment> citas;

    public MedicalRecord(){
        
    }
    
    public MedicalRecord(int idHistoria) {
        this.idHistoria = idHistoria;
        this.citas = new ArrayList<Appointment>();
    }
    
    public MedicalRecord(int idHistoria, List<Appointment> citas) {
        this.idHistoria = idHistoria;
        this.citas = citas;
    }
    

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public List<Appointment> getCitas() {
        return citas;
    }

    public void setCitas(List<Appointment> citas) {
        this.citas = citas;
    }
    
    public void updateAppointment(Integer id) {
        Integer index = getIndexAppointment(id);
        citas.set(index, getAppointment(id));
    }
    
    public void removeAppointment(Integer id) {
        Appointment appointment = getAppointment(id);
        citas.remove(appointment);
    }
    
    public Appointment getAppointment(Integer id) {
        for (Appointment a : citas) {
            if (a.getIdAppointment() == id.intValue()) {
                return a;
            }
        }
        return null;
    }
    
    public Integer getIndexAppointment(Integer id) {
        int index = 0;
        for (Appointment a : citas) {
            if (a.getIdAppointment() == id.intValue()) {
                break;
            }
            index += 1;
        }
        return index;
    }
    
    public void add(Appointment appointment) {
        this.citas.add(appointment);
    }
}
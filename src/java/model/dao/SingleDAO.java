/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import model.MedicalRecord;
import model.Person;

/**
 *
 * @author Sebastian
 */
public class SingleDAO {
    private Mongo mongo = null;
    private Morphia morphia = null;
    private String dbName = "EPS";

    //Specific DAO's
    private PersonaDAO personaDAO;
    private HistoriaClinicaDAO historiaDAO;
    
    public SingleDAO() {
        
        mongo = null;
        try {
            mongo = new Mongo("localhost", 27017);
        } catch(UnknownHostException e){}
        
        morphia = new Morphia();
        morphia.map(Person.class).map(MedicalRecord.class);
        
        personaDAO = new PersonaDAO(mongo, morphia, dbName);
        historiaDAO = new HistoriaClinicaDAO(mongo, morphia, dbName);
    }

    public PersonaDAO getPersonaDAO() {
        return personaDAO;
    }

    public HistoriaClinicaDAO getHistoriaDAO() {
        return historiaDAO;
    }
    
    public synchronized static SingleDAO getInstance() {
		while (m_this == null) {
			m_this = new SingleDAO();
		}
		return m_this;
    }
    
    private static SingleDAO m_this;
}
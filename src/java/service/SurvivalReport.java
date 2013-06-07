/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import model.Person;
import model.dao.SingleDAO;

/**
 *
 * @author Camilo
 */
public class SurvivalReport {

    public String fallecido(int id) {
        Person person;
        person = SingleDAO.getInstance().getPersonaDAO().get(id);
        return person.getNombre();

    }

    public String nacido(String nombre) {
        return nombre;

    }
}

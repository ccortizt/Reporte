/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import service.SurvivalReport;

/**
 *
 * @author Camilo
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class Survival {
      /**
     * Web service operation
     */
    @WebMethod(operationName = "reportDeath")
    public String reportDeath(int id) {
        
        return new SurvivalReport().fallecido(id);
    }
    
    @WebMethod(operationName = "reportBirth")
    public String reportBirth(String name) {
        
        return new SurvivalReport().nacido(name);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;

/**
 *
 * @author Camilo
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class Supervivencia {
      /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public String operation( String test) {
        
        return test;
    }
    
}

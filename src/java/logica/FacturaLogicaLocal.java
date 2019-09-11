/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Factura;

/**
 *
 * @author CANDELO
 */
@Local
public interface FacturaLogicaLocal {
    
    public void registrarItem(Factura fa) throws Exception;
    
    public List<Factura> consultaFactura();
    
    public void modificarItem(Factura fa) throws Exception;
    
    public void eliminarItem(Factura fa) throws Exception;
  
    
}

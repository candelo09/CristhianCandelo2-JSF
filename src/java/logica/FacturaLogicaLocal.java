/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.DetalleFactura;
import modelo.Productos;
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Local
public interface FacturaLogicaLocal {
    
    public void registrarItem(DetalleFactura fa) throws Exception;
    
    public void registrarVenta(Ventas ve) throws Exception;
    
    public List<DetalleFactura> consultaFactura();
    
    public void modificarItem(DetalleFactura fa) throws Exception;
        
    public List<Productos> consultaProductos();
    
    public DetalleFactura traerValorTotal(Ventas codV, Productos codP);
    
    
    
  
    
}

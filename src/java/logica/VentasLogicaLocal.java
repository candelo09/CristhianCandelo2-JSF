/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.Ventas;

/**
 *
 * @author CANDELO
 */
@Local
public interface VentasLogicaLocal {
     public void registrarVenta(Ventas ve) throws Exception;
    
    public List<Ventas> consultaVentas();
    
    public void modificarVenta(Ventas ve) throws Exception;
    
    public void eliminarVenta(Ventas ve) throws Exception;
}

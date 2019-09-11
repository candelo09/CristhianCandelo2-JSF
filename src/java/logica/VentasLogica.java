/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Ventas;
import persistencia.VentasFacadeLocal;

/**
 *
 * @author CANDELO
 */
@Stateless
public class VentasLogica implements VentasLogicaLocal {
    
    @EJB
    
    public VentasFacadeLocal ventasDao;

    @Override
    public void registrarVenta(Ventas ve) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ventas> consultaVentas() {
        return ventasDao.findAll();
    }

    @Override
    public void modificarVenta(Ventas ve) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarVenta(Ventas ve) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
